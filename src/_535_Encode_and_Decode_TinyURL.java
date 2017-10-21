import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * @author shengyizhang
 *
 */
// Note: pass

public class _535_Encode_and_Decode_TinyURL {

    int count = 0;
    Map<String, String> map1 = new HashMap<String, String>();
    Map<String, String> map2 = new HashMap<String, String>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String convertedNumber = convert(count);
        
        if (map1.containsKey(longUrl)) {
        	return map1.get(longUrl);
        }
        
        count++;
        
        map1.put(longUrl, convertedNumber);
        map2.put(convertedNumber, longUrl);
        
        return convertedNumber;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map2.get(shortUrl);
    }
    
    private String convert(int input) {
    	String code = "0123456789abcdefghigklmnopqrstuvqxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	StringBuilder sb = new StringBuilder();
    	
    	while (input > 0) {
    		sb.append(code.charAt(input % 62));
    		input = input / 62;
    	}
    	
    	return sb.toString();
    }
}
