package cn.silen_dev.parse;

import cn.silen_dev.model.Movie;
import cn.silen_dev.model.Rate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    public static Movie parseMovie(String html, int movieId) {
        Movie movie = new Movie();
        movie.setId(movieId);
        String movieInfo = regex("<script type=\"application/ld\\+json\">([\\s\\S]*?)</script>", html).get("group1");

        movie.setImage(regex("\"image\": \"(.*?)\"", movieInfo).get("group1"));
        movie.setTitle(regex("\"name\": \"(.*?)\"", movieInfo).get("group1"));
        movie.setDirector(parsePerson("\"director\":([\\s\\S]*?)\\]", movieInfo));
        movie.setAuthor(parsePerson("\"author\":([\\s\\S]*?)\\]", movieInfo));
        movie.setActor(parsePerson("\"actor\":([\\s\\S]*?)\\]", movieInfo));
        movie.setDatePublished(regex("datePublished\": \"(.*?)\"", movieInfo).get("group1"));
        movie.setType(regex(",[\\s\\S]{0,4}\"@type\": \"([\\w]*?)\"", movieInfo).get("group1"));

        parseGenre(movie, movieInfo);

        movie.setDuration(regex("<span property=\"v:runtime\" content=\"([\\d]*?)\"",html).get("group1"));
        movie.setCountry(regex("制片国家/地区:</span>(.*?)<br/>",html).get("group1"));
        movie.setLanguage(regex("语言:</span>(.*?)<br/>",html).get("group1"));
        movie.setDescription(regex("property=\"v:summary\" class=\"\">[\\s]*(.*?)[\\s]*?</span>",html).get("group1"));


        System.out.println(movie);

        Rate rate= parseRate(html,movieId);
        System.out.println("\n"+rate);
        return movie;
    }

    public static Rate parseRate(String html,int movieId){
        Rate rate=new Rate();
        rate.setMovieId(movieId);
        rate.setDataTime(System.currentTimeMillis());
        rate.setRatingValue(Float.parseFloat(regex("property=\"v:average\">(.*?)</strong>",html).get("group1")));
        rate.setRatingCount(Integer.parseInt(regex("roperty=\"v:votes\">([\\d]*)</span>",html).get("group1")));

        List<Map<String,String>> ratePercent=regexMul("class=\"rating_per\">(.*?)%</span>",html);
        rate.setFivePercent(Float.parseFloat(ratePercent.get(0).get("group1")));
        rate.setFourPercent(Float.parseFloat(ratePercent.get(1).get("group1")));
        rate.setThreePercent(Float.parseFloat(ratePercent.get(2).get("group1")));
        rate.setTwoPercent(Float.parseFloat(ratePercent.get(3).get("group1")));
        rate.setOnePercent(Float.parseFloat(ratePercent.get(4).get("group1")));

        return rate;
    }

    private static String parsePerson(String regex, String html) {
        List<Map<String, String>> director = regexMul("\"url\": \"/celebrity/([\\d]*)/\",[\\s]*\"name\": \"(.*?) (.*?)\"", regex(regex, html).get("group1"));
        StringBuilder builder = new StringBuilder();
        for (Map<String, String> map : director) {
            builder.append("|" + map.get("group1") + "/" + map.get("group2"));
        }
        return builder.toString();
    }

    private static void parseGenre(Movie movie, String html) {
        List<Map<String, String>> genre = regexMul("\"(\\\\u.*?)\"", html);
        StringBuilder builder = new StringBuilder();

        for (Map<String, String> map : genre) {
            builder.append("|" + convertCharset(map.get("group1")));
        }
        movie.setGenre(builder.toString());
    }

    private static String convertCharset(String in) {
        StringBuffer sb = new StringBuffer(in);

        int pos;
        while ((pos = sb.indexOf("\\u")) > -1) {
            String tmp = sb.substring(pos, pos + 6);
            sb.replace(pos, pos + 6, Character.toString((char) Integer.parseInt(tmp.substring(2), 16)));
        }
        return sb.toString();
    }

    private static List<Map<String, String>> regexMul(String regex, String html) {
        List<Map<String, String>> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i <= matcher.groupCount(); i++) {
                map.put("group" + i, matcher.group(i));
            }
            result.add(map);
        }
        return result;
    }

    private static Map<String, String> regex(String regex, String html) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i <= matcher.groupCount(); i++) {
                map.put("group" + i, matcher.group(i).trim());
            }
            return map;
        }
        return null;
    }
}
