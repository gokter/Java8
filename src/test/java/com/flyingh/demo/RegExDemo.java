package com.flyingh.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExDemo {

	@Test
	public void test6() {
		System.out.println(separateThousands("-1234567890.1234567890"));
	}

	private String separateThousands(String s) {
		return s.replaceAll("(?<=\\G\\d{3})(?=\\d)" + "|" + "(?<=^-?\\d{1,3})(?=(?:\\d{3})+(?!\\d))", ",");
	}

	@Test
	public void test5() {
		final String string = "abcdefghijklmnopqrstuvwxyz";
		final String[] strs = string.split("(?<=\\G.{6})");
		for (final String str : strs) {
			System.out.println(str);
		}
	}

	@Test
	public void test4() {
		final Matcher matcher = Pattern.compile("\\Gdog").matcher("dog dog");
		while (matcher.find()) {
			System.out.format("%s-->start:%d,end:%d%n", matcher.group(), matcher.start(), matcher.end());
		}
	}

	@Test
	public void test3() {
		final Matcher matcher = Pattern.compile("(a(b)(c(d)))").matcher("abcd");
		System.out.println(matcher.matches());
		System.out.println(matcher.groupCount());
		System.out.println(matcher.start(3));
		System.out.println(matcher.end(3));
		System.out.println(matcher.group(3));
		System.out.println(matcher.group(2));
	}

	@Test
	public void test2() {
		System.out.println("2".matches("[0-3&&[^3]]"));
	}

	@Test
	public void test() {
		// final Matcher matcher = Pattern.compile("a?").matcher("b");
		// final Matcher matcher = Pattern.compile("a{3}").matcher("aaaa");
		// final Matcher matcher = Pattern.compile("a{3,6}").matcher("aaaaaaaaa");
		final Matcher matcher = Pattern.compile(".*?foo").matcher("xfooxxxxxxfoo");
		while (matcher.find()) {
			System.out.format("%s-->start:%d,end:%d%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}
