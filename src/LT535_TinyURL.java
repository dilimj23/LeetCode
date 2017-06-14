import java.util.HashMap;

public class LT535_TinyURL {
    HashMap<String, String> index = new HashMap();
    HashMap<String, String> revindex = new HashMap();
    static String BASE_HOST = "http://tinyrul.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (revindex.containsKey(longUrl)) return BASE_HOST + revindex.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        index.put(key, longUrl);
        revindex.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }

    public static void main(String[] args) {
        LT535_TinyURL codec = new LT535_TinyURL();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(codec.decode(codec.encode(longUrl)));
    }
}
