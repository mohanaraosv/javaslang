package javaslang.util;

import static javaslang.util.Strings.escape;
import static javaslang.util.Strings.repeat;
import static javaslang.util.Strings.split;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class StringsTest {

	@Test
	public void shouldRepeatNullAsNull() {
		final String s = repeat(null, 2);
		assertThat(s).isNull();
	}

	@Test
	public void shouldRepeatZeroTimes() {
		final String s = repeat("x", 0);
		assertThat(s).isEqualTo("");
	}

	@Test
	public void shouldRepeatOneTime() {
		final String s = repeat("x", 1);
		assertThat(s).isEqualTo("x");
	}

	@Test
	public void shouldRepeatTwoTimes() {
		final String s = repeat("x", 2);
		assertThat(s).isEqualTo("xx");
	}

	@Test
	public void shouldRepeatNegativeTimes() {
		final String s = repeat("x", -2);
		assertThat(s).isEqualTo("");
	}

	@Test
	public void shouldNotRepeatNegativeTime() {
		final String s = escape(null);
		assertThat(s).isNull();
	}

	@Test
	public void shouldEscapeNull() {
		final String s = escape(null);
		assertThat(s).isNull();
	}

	@Test
	public void shouldEscapeEmptyString() {
		final String s = escape("");
		assertThat(s).isEqualTo("");
	}

	@Test
	public void shouldEscapeQuotes() {
		final String s = escape("\"");
		assertThat(s).isEqualTo("\\\"");
	}

	@Test
	public void shouldEscapeEscapeChar() {
		final String s = escape("\\");
		assertThat(s).isEqualTo("\\\\");
	}

	@Test
	public void shouldNotEscapeNonEscapeChars() {
		final String name = getClass().getName();
		final String s = escape(name);
		assertThat(s).isEqualTo(name);
	}

	@Test
	public void shouldSplitEmptyString() {
		final String[] actual = split("", "#");
		assertThat(actual).isEqualTo(new String[] { "" });
	}

	@Test
	public void shouldSplitWithOneSeparator() {
		final String[] actual = split("#", "#");
		assertThat(actual).isEqualTo(new String[] { "", "" });
	}

	@Test
	public void shouldSplitWithTwoSeparators() {
		final String[] actual = split("##", "#");
		assertThat(actual).isEqualTo(new String[] { "", "", "" });
	}

	@Test
	public void shouldSplitWithEmptyInnerToken() {
		final String[] actual = split("123##456", "#");
		assertThat(actual).isEqualTo(new String[] { "123", "", "456" });
	}

	@Test
	public void shouldSplitWithLongSeparators() {
		final String[] actual = split("123##456", "##");
		assertThat(actual).isEqualTo(new String[] { "123", "456" });
	}

	@Test
	public void shouldSplitEmptyStartAndEndToken() {
		final String[] actual = split("#123#", "#");
		assertThat(actual).isEqualTo(new String[] { "", "123", "" });
	}
}