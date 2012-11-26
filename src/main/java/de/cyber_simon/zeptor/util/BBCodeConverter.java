package de.cyber_simon.zeptor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("bbCodeConverter")
@Singleton
public class BBCodeConverter {

	Map<Pattern,String> bbMap;
	
	@PostConstruct
	public void init() {
		bbMap = new HashMap<Pattern , String>();
		bbMap.put(Pattern.compile("(\r\n|\r|\n|\n\r)"), "<br/>");
        bbMap.put(Pattern.compile("\\[b\\](.+?)\\[/b\\]"), "<strong>$1</strong>");
        bbMap.put(Pattern.compile("\\[i\\](.+?)\\[/i\\]"), "<span style='font-style:italic;'>$1</span>");
        bbMap.put(Pattern.compile("\\[u\\](.+?)\\[/u\\]"), "<span style='text-decoration:underline;'>$1</span>");
        bbMap.put(Pattern.compile("(?s)\\[h1\\](.+?)\\[/h1\\]"), "<h1>$1</h1>");
        bbMap.put(Pattern.compile("(?s)\\[h2\\](.+?)\\[/h2\\]"), "<h2>$1</h2>");
        bbMap.put(Pattern.compile("(?s)\\[h3\\](.+?)\\[/h3\\]"), "<h3>$1</h3>");
        bbMap.put(Pattern.compile("(?s)\\[h4\\](.+?)\\[/h4\\]"), "<h4>$1</h4>");
        bbMap.put(Pattern.compile("(?s)\\[h5\\](.+?)\\[/h5\\]"), "<h5>$1</h5>");
        bbMap.put(Pattern.compile("(?s)\\[h6\\](.+?)\\[/h6\\]"), "<h6>$1</h6>");
        bbMap.put(Pattern.compile("(?s)\\[ul\\](.+?)\\[/ul\\]"), "<ul>$1</ul>");
        bbMap.put(Pattern.compile("(?s)\\[li\\](.+?)\\[/li\\]"), "<li>$1</li>");
        bbMap.put(Pattern.compile("(?s)\\[quote\\](.+?)\\[/quote\\]"), "<blockquote>$1</blockquote>");
        bbMap.put(Pattern.compile("(?s)\\[p\\](.+?)\\[/p\\]"), "<p>$1</p>");
        bbMap.put(Pattern.compile("(?s)\\[p=(.+?),(.+?)\\](.+?)\\[/p\\]"), "<p style='text-indent:$1px;line-height:$2%;'>$3</p>");
        bbMap.put(Pattern.compile("(?s)\\[center\\](.+?)\\[/center\\]"), "<div align='center'>$1");
        bbMap.put(Pattern.compile("(?s)\\[align=(.+?)\\](.+?)\\[/align\\]"), "<div align='$1'>$2");
        bbMap.put(Pattern.compile("(?s)\\[color=(.+?)\\](.+?)\\[/color\\]"), "<span style='color:$1;'>$2</span>");
        bbMap.put(Pattern.compile("(?s)\\[size=(.+?)\\](.+?)\\[/size\\]"), "<span style='font-size:$1;'>$2</span>");
        bbMap.put(Pattern.compile("\\[img\\](.+?)\\[/img\\]"), "<img src='$1' />");
        bbMap.put(Pattern.compile("\\[img=(.+?),(.+?)\\](.+?)\\[/img\\]"), "<img width='$1' height='$2' src='$3' />");
        bbMap.put(Pattern.compile("\\[email\\](.+?)\\[/email\\]"), "<a href='mailto:$1'>$1</a>");
        bbMap.put(Pattern.compile("\\[email=(.+?)\\](.+?)\\[/email\\]"), "<a href='mailto:$1'>$2</a>");
        bbMap.put(Pattern.compile("\\[url\\](.+?)\\[/url\\]"), "<a href='$1' target='_blank'>$1</a>");
        bbMap.put(Pattern.compile("\\[url=(.+?)\\](.+?)\\[/url\\]"), "<a href='$1' target='_blank'>$2</a>");
        bbMap.put(Pattern.compile("\\[youtube\\](.+?)\\[/youtube\\]"), "<object width='640' height='380'><param name='movie' value='http://www.youtube.com/v/$1'></param><embed src='http://www.youtube.com/v/$1' type='application/x-shockwave-flash' width='640' height='380'></embed></object>");
        bbMap.put(Pattern.compile("\\[video\\](.+?)\\[/video\\]"), "<video src='$1' />");		
	}
	
	public String convert(String text) {
		if (text == null) return null;

		for (Map.Entry<Pattern, String> entry: bbMap.entrySet()) {
			text = entry.getKey().matcher(text).replaceAll(entry.getValue());
        }

        return text;
	}
}
