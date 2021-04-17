import java.lang.System;
class Analex {
      public static void main(String argv[])
	throws java.io.IOException {
	Yylex yy = new Yylex(System.in);
	while (yy.yylex() != null) {}	
    }
}
class Yytoken {
  Yytoken () {}
}


class Yylex {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int COMENTARIO = 1;
	private final int yy_state_dtrans[] = {
		0,
		341
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NO_ANCHOR,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NOT_ACCEPT,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NOT_ACCEPT,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NOT_ACCEPT,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NOT_ACCEPT,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NOT_ACCEPT,
		/* 153 */ YY_NO_ANCHOR,
		/* 154 */ YY_NOT_ACCEPT,
		/* 155 */ YY_NO_ANCHOR,
		/* 156 */ YY_NOT_ACCEPT,
		/* 157 */ YY_NO_ANCHOR,
		/* 158 */ YY_NOT_ACCEPT,
		/* 159 */ YY_NO_ANCHOR,
		/* 160 */ YY_NOT_ACCEPT,
		/* 161 */ YY_NO_ANCHOR,
		/* 162 */ YY_NOT_ACCEPT,
		/* 163 */ YY_NO_ANCHOR,
		/* 164 */ YY_NOT_ACCEPT,
		/* 165 */ YY_NO_ANCHOR,
		/* 166 */ YY_NOT_ACCEPT,
		/* 167 */ YY_NO_ANCHOR,
		/* 168 */ YY_NOT_ACCEPT,
		/* 169 */ YY_NO_ANCHOR,
		/* 170 */ YY_NOT_ACCEPT,
		/* 171 */ YY_NO_ANCHOR,
		/* 172 */ YY_NOT_ACCEPT,
		/* 173 */ YY_NO_ANCHOR,
		/* 174 */ YY_NOT_ACCEPT,
		/* 175 */ YY_NO_ANCHOR,
		/* 176 */ YY_NOT_ACCEPT,
		/* 177 */ YY_NO_ANCHOR,
		/* 178 */ YY_NOT_ACCEPT,
		/* 179 */ YY_NO_ANCHOR,
		/* 180 */ YY_NOT_ACCEPT,
		/* 181 */ YY_NO_ANCHOR,
		/* 182 */ YY_NOT_ACCEPT,
		/* 183 */ YY_NO_ANCHOR,
		/* 184 */ YY_NOT_ACCEPT,
		/* 185 */ YY_NOT_ACCEPT,
		/* 186 */ YY_NOT_ACCEPT,
		/* 187 */ YY_NOT_ACCEPT,
		/* 188 */ YY_NOT_ACCEPT,
		/* 189 */ YY_NOT_ACCEPT,
		/* 190 */ YY_NOT_ACCEPT,
		/* 191 */ YY_NOT_ACCEPT,
		/* 192 */ YY_NOT_ACCEPT,
		/* 193 */ YY_NOT_ACCEPT,
		/* 194 */ YY_NOT_ACCEPT,
		/* 195 */ YY_NOT_ACCEPT,
		/* 196 */ YY_NOT_ACCEPT,
		/* 197 */ YY_NOT_ACCEPT,
		/* 198 */ YY_NOT_ACCEPT,
		/* 199 */ YY_NOT_ACCEPT,
		/* 200 */ YY_NOT_ACCEPT,
		/* 201 */ YY_NOT_ACCEPT,
		/* 202 */ YY_NOT_ACCEPT,
		/* 203 */ YY_NOT_ACCEPT,
		/* 204 */ YY_NOT_ACCEPT,
		/* 205 */ YY_NOT_ACCEPT,
		/* 206 */ YY_NOT_ACCEPT,
		/* 207 */ YY_NOT_ACCEPT,
		/* 208 */ YY_NOT_ACCEPT,
		/* 209 */ YY_NOT_ACCEPT,
		/* 210 */ YY_NOT_ACCEPT,
		/* 211 */ YY_NOT_ACCEPT,
		/* 212 */ YY_NOT_ACCEPT,
		/* 213 */ YY_NOT_ACCEPT,
		/* 214 */ YY_NOT_ACCEPT,
		/* 215 */ YY_NOT_ACCEPT,
		/* 216 */ YY_NOT_ACCEPT,
		/* 217 */ YY_NOT_ACCEPT,
		/* 218 */ YY_NOT_ACCEPT,
		/* 219 */ YY_NOT_ACCEPT,
		/* 220 */ YY_NOT_ACCEPT,
		/* 221 */ YY_NOT_ACCEPT,
		/* 222 */ YY_NOT_ACCEPT,
		/* 223 */ YY_NOT_ACCEPT,
		/* 224 */ YY_NOT_ACCEPT,
		/* 225 */ YY_NOT_ACCEPT,
		/* 226 */ YY_NOT_ACCEPT,
		/* 227 */ YY_NOT_ACCEPT,
		/* 228 */ YY_NOT_ACCEPT,
		/* 229 */ YY_NOT_ACCEPT,
		/* 230 */ YY_NOT_ACCEPT,
		/* 231 */ YY_NOT_ACCEPT,
		/* 232 */ YY_NOT_ACCEPT,
		/* 233 */ YY_NOT_ACCEPT,
		/* 234 */ YY_NOT_ACCEPT,
		/* 235 */ YY_NOT_ACCEPT,
		/* 236 */ YY_NOT_ACCEPT,
		/* 237 */ YY_NOT_ACCEPT,
		/* 238 */ YY_NOT_ACCEPT,
		/* 239 */ YY_NOT_ACCEPT,
		/* 240 */ YY_NOT_ACCEPT,
		/* 241 */ YY_NOT_ACCEPT,
		/* 242 */ YY_NOT_ACCEPT,
		/* 243 */ YY_NOT_ACCEPT,
		/* 244 */ YY_NOT_ACCEPT,
		/* 245 */ YY_NOT_ACCEPT,
		/* 246 */ YY_NOT_ACCEPT,
		/* 247 */ YY_NOT_ACCEPT,
		/* 248 */ YY_NOT_ACCEPT,
		/* 249 */ YY_NOT_ACCEPT,
		/* 250 */ YY_NOT_ACCEPT,
		/* 251 */ YY_NOT_ACCEPT,
		/* 252 */ YY_NOT_ACCEPT,
		/* 253 */ YY_NOT_ACCEPT,
		/* 254 */ YY_NOT_ACCEPT,
		/* 255 */ YY_NOT_ACCEPT,
		/* 256 */ YY_NOT_ACCEPT,
		/* 257 */ YY_NOT_ACCEPT,
		/* 258 */ YY_NOT_ACCEPT,
		/* 259 */ YY_NOT_ACCEPT,
		/* 260 */ YY_NOT_ACCEPT,
		/* 261 */ YY_NOT_ACCEPT,
		/* 262 */ YY_NOT_ACCEPT,
		/* 263 */ YY_NOT_ACCEPT,
		/* 264 */ YY_NOT_ACCEPT,
		/* 265 */ YY_NOT_ACCEPT,
		/* 266 */ YY_NOT_ACCEPT,
		/* 267 */ YY_NOT_ACCEPT,
		/* 268 */ YY_NOT_ACCEPT,
		/* 269 */ YY_NOT_ACCEPT,
		/* 270 */ YY_NOT_ACCEPT,
		/* 271 */ YY_NOT_ACCEPT,
		/* 272 */ YY_NOT_ACCEPT,
		/* 273 */ YY_NOT_ACCEPT,
		/* 274 */ YY_NOT_ACCEPT,
		/* 275 */ YY_NOT_ACCEPT,
		/* 276 */ YY_NOT_ACCEPT,
		/* 277 */ YY_NOT_ACCEPT,
		/* 278 */ YY_NOT_ACCEPT,
		/* 279 */ YY_NOT_ACCEPT,
		/* 280 */ YY_NOT_ACCEPT,
		/* 281 */ YY_NOT_ACCEPT,
		/* 282 */ YY_NOT_ACCEPT,
		/* 283 */ YY_NOT_ACCEPT,
		/* 284 */ YY_NOT_ACCEPT,
		/* 285 */ YY_NOT_ACCEPT,
		/* 286 */ YY_NOT_ACCEPT,
		/* 287 */ YY_NOT_ACCEPT,
		/* 288 */ YY_NOT_ACCEPT,
		/* 289 */ YY_NOT_ACCEPT,
		/* 290 */ YY_NOT_ACCEPT,
		/* 291 */ YY_NOT_ACCEPT,
		/* 292 */ YY_NOT_ACCEPT,
		/* 293 */ YY_NOT_ACCEPT,
		/* 294 */ YY_NOT_ACCEPT,
		/* 295 */ YY_NOT_ACCEPT,
		/* 296 */ YY_NOT_ACCEPT,
		/* 297 */ YY_NOT_ACCEPT,
		/* 298 */ YY_NOT_ACCEPT,
		/* 299 */ YY_NOT_ACCEPT,
		/* 300 */ YY_NOT_ACCEPT,
		/* 301 */ YY_NOT_ACCEPT,
		/* 302 */ YY_NOT_ACCEPT,
		/* 303 */ YY_NOT_ACCEPT,
		/* 304 */ YY_NOT_ACCEPT,
		/* 305 */ YY_NOT_ACCEPT,
		/* 306 */ YY_NOT_ACCEPT,
		/* 307 */ YY_NOT_ACCEPT,
		/* 308 */ YY_NOT_ACCEPT,
		/* 309 */ YY_NOT_ACCEPT,
		/* 310 */ YY_NOT_ACCEPT,
		/* 311 */ YY_NOT_ACCEPT,
		/* 312 */ YY_NOT_ACCEPT,
		/* 313 */ YY_NOT_ACCEPT,
		/* 314 */ YY_NOT_ACCEPT,
		/* 315 */ YY_NOT_ACCEPT,
		/* 316 */ YY_NOT_ACCEPT,
		/* 317 */ YY_NOT_ACCEPT,
		/* 318 */ YY_NOT_ACCEPT,
		/* 319 */ YY_NOT_ACCEPT,
		/* 320 */ YY_NOT_ACCEPT,
		/* 321 */ YY_NOT_ACCEPT,
		/* 322 */ YY_NOT_ACCEPT,
		/* 323 */ YY_NOT_ACCEPT,
		/* 324 */ YY_NOT_ACCEPT,
		/* 325 */ YY_NOT_ACCEPT,
		/* 326 */ YY_NOT_ACCEPT,
		/* 327 */ YY_NOT_ACCEPT,
		/* 328 */ YY_NOT_ACCEPT,
		/* 329 */ YY_NOT_ACCEPT,
		/* 330 */ YY_NOT_ACCEPT,
		/* 331 */ YY_NOT_ACCEPT,
		/* 332 */ YY_NOT_ACCEPT,
		/* 333 */ YY_NOT_ACCEPT,
		/* 334 */ YY_NOT_ACCEPT,
		/* 335 */ YY_NOT_ACCEPT,
		/* 336 */ YY_NOT_ACCEPT,
		/* 337 */ YY_NOT_ACCEPT,
		/* 338 */ YY_NOT_ACCEPT,
		/* 339 */ YY_NOT_ACCEPT,
		/* 340 */ YY_NOT_ACCEPT,
		/* 341 */ YY_NOT_ACCEPT,
		/* 342 */ YY_NOT_ACCEPT,
		/* 343 */ YY_NOT_ACCEPT,
		/* 344 */ YY_NOT_ACCEPT,
		/* 345 */ YY_NOT_ACCEPT,
		/* 346 */ YY_NO_ANCHOR,
		/* 347 */ YY_NOT_ACCEPT,
		/* 348 */ YY_NOT_ACCEPT,
		/* 349 */ YY_NOT_ACCEPT,
		/* 350 */ YY_NOT_ACCEPT,
		/* 351 */ YY_NOT_ACCEPT,
		/* 352 */ YY_NOT_ACCEPT,
		/* 353 */ YY_NOT_ACCEPT,
		/* 354 */ YY_NOT_ACCEPT,
		/* 355 */ YY_NOT_ACCEPT,
		/* 356 */ YY_NOT_ACCEPT,
		/* 357 */ YY_NOT_ACCEPT,
		/* 358 */ YY_NOT_ACCEPT,
		/* 359 */ YY_NOT_ACCEPT,
		/* 360 */ YY_NOT_ACCEPT,
		/* 361 */ YY_NOT_ACCEPT,
		/* 362 */ YY_NOT_ACCEPT,
		/* 363 */ YY_NOT_ACCEPT,
		/* 364 */ YY_NOT_ACCEPT,
		/* 365 */ YY_NOT_ACCEPT,
		/* 366 */ YY_NOT_ACCEPT,
		/* 367 */ YY_NOT_ACCEPT,
		/* 368 */ YY_NOT_ACCEPT,
		/* 369 */ YY_NOT_ACCEPT,
		/* 370 */ YY_NOT_ACCEPT,
		/* 371 */ YY_NOT_ACCEPT,
		/* 372 */ YY_NOT_ACCEPT,
		/* 373 */ YY_NOT_ACCEPT,
		/* 374 */ YY_NOT_ACCEPT,
		/* 375 */ YY_NOT_ACCEPT,
		/* 376 */ YY_NOT_ACCEPT,
		/* 377 */ YY_NOT_ACCEPT,
		/* 378 */ YY_NOT_ACCEPT,
		/* 379 */ YY_NOT_ACCEPT,
		/* 380 */ YY_NOT_ACCEPT,
		/* 381 */ YY_NOT_ACCEPT,
		/* 382 */ YY_NOT_ACCEPT,
		/* 383 */ YY_NOT_ACCEPT,
		/* 384 */ YY_NOT_ACCEPT,
		/* 385 */ YY_NOT_ACCEPT,
		/* 386 */ YY_NOT_ACCEPT,
		/* 387 */ YY_NOT_ACCEPT,
		/* 388 */ YY_NOT_ACCEPT,
		/* 389 */ YY_NOT_ACCEPT,
		/* 390 */ YY_NOT_ACCEPT,
		/* 391 */ YY_NOT_ACCEPT,
		/* 392 */ YY_NOT_ACCEPT,
		/* 393 */ YY_NOT_ACCEPT,
		/* 394 */ YY_NOT_ACCEPT,
		/* 395 */ YY_NOT_ACCEPT,
		/* 396 */ YY_NOT_ACCEPT,
		/* 397 */ YY_NOT_ACCEPT,
		/* 398 */ YY_NOT_ACCEPT,
		/* 399 */ YY_NOT_ACCEPT,
		/* 400 */ YY_NOT_ACCEPT,
		/* 401 */ YY_NOT_ACCEPT,
		/* 402 */ YY_NOT_ACCEPT,
		/* 403 */ YY_NOT_ACCEPT,
		/* 404 */ YY_NOT_ACCEPT,
		/* 405 */ YY_NOT_ACCEPT,
		/* 406 */ YY_NOT_ACCEPT,
		/* 407 */ YY_NOT_ACCEPT,
		/* 408 */ YY_NOT_ACCEPT,
		/* 409 */ YY_NOT_ACCEPT,
		/* 410 */ YY_NOT_ACCEPT,
		/* 411 */ YY_NOT_ACCEPT,
		/* 412 */ YY_NOT_ACCEPT,
		/* 413 */ YY_NOT_ACCEPT,
		/* 414 */ YY_NOT_ACCEPT,
		/* 415 */ YY_NOT_ACCEPT,
		/* 416 */ YY_NOT_ACCEPT,
		/* 417 */ YY_NOT_ACCEPT,
		/* 418 */ YY_NOT_ACCEPT,
		/* 419 */ YY_NOT_ACCEPT,
		/* 420 */ YY_NOT_ACCEPT,
		/* 421 */ YY_NOT_ACCEPT,
		/* 422 */ YY_NOT_ACCEPT,
		/* 423 */ YY_NOT_ACCEPT,
		/* 424 */ YY_NOT_ACCEPT,
		/* 425 */ YY_NOT_ACCEPT,
		/* 426 */ YY_NOT_ACCEPT,
		/* 427 */ YY_NOT_ACCEPT,
		/* 428 */ YY_NOT_ACCEPT,
		/* 429 */ YY_NOT_ACCEPT,
		/* 430 */ YY_NOT_ACCEPT,
		/* 431 */ YY_NOT_ACCEPT,
		/* 432 */ YY_NOT_ACCEPT,
		/* 433 */ YY_NOT_ACCEPT,
		/* 434 */ YY_NOT_ACCEPT,
		/* 435 */ YY_NOT_ACCEPT,
		/* 436 */ YY_NOT_ACCEPT,
		/* 437 */ YY_NOT_ACCEPT,
		/* 438 */ YY_NOT_ACCEPT,
		/* 439 */ YY_NOT_ACCEPT,
		/* 440 */ YY_NOT_ACCEPT,
		/* 441 */ YY_NOT_ACCEPT,
		/* 442 */ YY_NOT_ACCEPT,
		/* 443 */ YY_NOT_ACCEPT,
		/* 444 */ YY_NOT_ACCEPT,
		/* 445 */ YY_NOT_ACCEPT,
		/* 446 */ YY_NOT_ACCEPT,
		/* 447 */ YY_NOT_ACCEPT,
		/* 448 */ YY_NOT_ACCEPT,
		/* 449 */ YY_NOT_ACCEPT,
		/* 450 */ YY_NOT_ACCEPT,
		/* 451 */ YY_NOT_ACCEPT,
		/* 452 */ YY_NOT_ACCEPT,
		/* 453 */ YY_NOT_ACCEPT,
		/* 454 */ YY_NOT_ACCEPT,
		/* 455 */ YY_NOT_ACCEPT,
		/* 456 */ YY_NOT_ACCEPT,
		/* 457 */ YY_NOT_ACCEPT
	};
	private int yy_cmap[] = unpackFromString(1,130,
"58:9,6,5,58:2,57,58:18,57,45,4,3,15,52,53,56,7,8,51,49,47,50,48,46,1:10,14," +
"13,43,44,42,58:2,2:5,39,2:12,41,2:7,9,58,10,58,55,58,16,22,24,18,25,35,20,3" +
"4,31,2,33,27,32,17,26,38,2,19,21,23,28,36,30,37,29,40,11,54,12,58:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,458,
"0,1:2,2,1:2,3,1:10,4,1:2,5,1:8,3,1,6,7,1:2,8,1:15,9,1:8,10,1:23,11,1:53,12," +
"1,13,14,15,16,17,18,19,20,21,1,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36" +
",37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61" +
",62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86" +
",87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108" +
",109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,12" +
"7,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,1" +
"46,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164," +
"165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183" +
",184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,20" +
"2,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,2" +
"21,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239," +
"240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258" +
",259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,27" +
"7,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,2" +
"96,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314," +
"315,316,317,318,319,320,321,322,323,324,325,326,327,328,329")[0];

	private int yy_nxt[][] = unpackFromString(330,59,
"1,140,2,3,4,5,6,7,8,9,10,11,12,13,14,15,141,145,148,151,153,155,157,159,161" +
",163,165,167,169,171,173,175,2:3,177,179,2,181,346,2,183,16,17,18,19,20,21," +
"22,23,24,25,26,142,146,27,28,29,149,-1:61,30,-1:13,30:15,143,30:10,-1:23,29" +
",-1:50,29,-1:32,394,-1:73,37,-1:4,38,-1:25,41,-1:68,353,-1,420,-1:49,437,-1" +
",51,233,-1:59,448,-1:58,432,-1:54,106,-1:83,139,-1:13,140,-1:74,31,-1,144,-" +
"1,147,150,-1:5,152,-1,154,-1:81,39,-1:22,355,-1:60,419,200,-1:54,343,-1:8,1" +
"56,158,-1,160,-1:2,162,-1:81,40,-1:25,422,-1:10,42,-1:51,164,32,-1:4,166,-1" +
":48,201,-1:62,168,-1:56,202,-1:61,388,-1:48,421,-1:65,170,-1,172,-1:2,174,1" +
"76,178,180,-1:2,182,-1:54,43,-1:47,184,-1:5,185,186,-1:2,418,-1:52,44,-1:54" +
",187,-1:6,33,-1:2,347,-1:4,188,-1:51,203,-1:47,189,-1:9,190,344,-1:6,389,-1" +
":51,45,-1:48,191,-1:9,342,-1:9,192,-1:42,204,205,-1:4,436,-1:7,206,-1:42,34" +
",-1:75,46,-1:38,193,-1:9,348,-1:48,207,-1:6,357,-1:52,349,-1:3,351,-1:53,35" +
"6,-1,47,209,-1:70,393,-1:50,48,-1:54,455,-1:11,434,-1:2,392,-1:62,444,-1:37" +
",35,-1:14,390,-1:2,36,-1:40,396,-1:57,345,-1:9,194,352,454,-1:2,391,-1:58,3" +
"97,-1:43,195,-1:9,196,-1:4,197,-1:67,450,-1:34,198,-1:2,350,-1:8,199,-1:56," +
"395,-1:4,210,-1:50,354,-1:5,387,-1:54,358,-1:53,211,-1:64,212,-1:48,214,-1:" +
"11,215,49,-1:48,217,-1:11,218,-1:48,219,-1,220,-1:52,221,-1:10,222,-1:48,50" +
",-1:9,225,-1:53,360,-1:14,227,-1:42,400,-1:55,52,-1:58,53,-1:66,438,-1:3,23" +
"4,-1:46,445,-1:63,235,-1:56,403,238,-1:56,54,-1:60,365,-1:2,439,-1:58,55,-1" +
":59,56,-1:54,404,-1:63,242,-1:46,244,-1:60,57,-1:66,58,-1:60,245,-1:2,246,-" +
"1:54,59,-1:62,251,-1:54,60,-1:56,61,-1:50,427,-1:66,62,-1:58,426,-1:59,252," +
"-1:53,63,-1:62,64,-1:67,65,-1:45,253,-1,254,-1:58,66,-1:56,255,-1:56,67,-1:" +
"71,68,-1:51,69,-1:52,70,-1:6,440,-1:52,71,-1:61,72,-1:2,258,-1:53,73,-1:64," +
"259,-1:65,74,-1:43,75,-1:57,76,-1:73,266,-1:45,453,-1:2,372,-1:71,373,-1:43" +
",77,-1:66,78,-1:48,268,-1:62,79,-1:55,366,-1:61,270,-1:63,374,-1:54,275,-1:" +
"51,276,-1:6,277,-1:53,80,-1:73,278,-1:47,81,-1:68,82,-1:42,83,-1:71,84,-1:5" +
"1,85,-1:66,409,-1:48,86,-1:54,282,-1:68,87,-1:48,88,-1:59,89,-1:65,412,-1:5" +
"8,90,-1:49,284,-1:67,91,-1:56,92,-1:62,93,-1:47,405,-1:69,433,-1:54,94,-1:6" +
"0,95,-1:58,96,-1:58,97,-1:59,98,-1:49,99,-1:65,100,-1:57,101,-1:55,102,-1:6" +
"1,378,-1:54,296,-1:73,103,-1:59,104,-1:58,105,-1:41,299,-1:63,107,-1:52,415" +
",-1:76,414,-1:46,108,-1:66,382,-1:58,443,-1:43,301,-1:66,304,-1:58,109,-1:5" +
"4,110,-1:70,307,-1:51,311,-1:56,111,-1:61,313,-1:49,112,-1:69,314,-1:51,113" +
",-1:54,114,-1:68,115,-1:56,116,-1:65,117,-1:49,385,-1:60,118,-1:62,119,-1:7" +
"7,319,-1:35,120,-1:56,121,-1:60,122,-1:52,123,-1:77,124,-1:37,321,-1:66,125" +
",-1:58,417,-1:57,323,-1:51,126,-1:66,127,-1:59,325,-1:48,326,-1:73,328,-1:5" +
"0,128,-1:60,129,-1:51,130,-1:68,330,-1:62,331,-1:45,131,-1:79,332,-1:53,132" +
",-1:46,333,-1:77,133,-1:41,334,-1:81,335,-1:28,134,-1:78,336,-1:39,337,-1:7" +
"0,338,-1:44,339,-1:64,449,-1:52,135,-1:41,1,136:4,137,136:40,149,136:4,138," +
"136:7,-1:21,226,-1:60,435,-1:51,223,-1:69,362,-1:62,457,-1:65,216,-1:37,228" +
",-1:72,229,-1:53,236,-1:4,237,-1:52,230,-1:59,398,-1:54,447,-1:55,359,-1:63" +
",428,-1:57,399,-1:63,429,-1:46,250,-1:73,371,-1:52,256,-1:59,452,-1:53,263," +
"-1:64,261,-1:67,269,-1:41,411,-1:59,294,-1:61,272,-1:63,289,-1:54,279,-1:65" +
",291,-1:44,292,-1:66,290,-1:49,375,-1:69,295,-1:54,305,-1:54,416,-1:57,308," +
"-1:75,312,-1:39,303,-1:66,309,-1:59,384,-1:59,317,-1:55,386,-1:52,322,-1:66" +
",324,-1:59,327,-1:53,451,-1:60,208,-1:51,224,-1:80,361,-1:37,425,-1:72,363," +
"-1:52,231,-1:59,402,-1:51,249,-1:63,248,-1:57,369,-1:51,264,-1:73,274,-1:52" +
",257,-1:59,280,-1:53,441,-1:64,370,-1:50,442,-1:59,302,-1:61,287,-1:63,377," +
"-1:61,381,-1:44,298,-1:66,293,-1:49,380,-1:69,300,-1:54,310,-1:51,316,-1:66" +
",315,-1:59,320,-1:59,329,-1:55,213,-1:51,239,-1:59,367,-1:72,241,-1:52,240," +
"-1:57,406,-1:57,260,-1:51,265,-1:68,281,-1:53,408,-1:64,407,-1:50,273,-1:62" +
",288,-1:63,413,-1:46,297,-1:69,306,-1:54,232,-1:66,364,-1:52,243,-1:56,262," +
"-1:51,430,-1:69,431,-1:50,283,-1:62,376,-1:63,456,-1:57,318,-1:56,247,-1:56" +
",368,-1:51,267,-1:69,271,-1:50,285,-1:66,340,-1:56,401,-1:56,410,-1:54,286," +
"-1:58,379,-1:56,423,-1:72,424,-1:51,383,-1:51,446,-1:41");

	public Yytoken yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  { System.exit(0); }
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 0:
						{ System.out.println ("NUMERO ");}
					case -2:
						break;
					case 1:
						
					case -3:
						break;
					case 2:
						{ System.out.println ("LETRA ");}
					case -4:
						break;
					case 3:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -5:
						break;
					case 4:
						{ System.out.println ("COMILLAS");}
					case -6:
						break;
					case 5:
						{ System.out.println ("SALTO DE LINEA");}
					case -7:
						break;
					case 6:
						{ System.out.println ("TABULACION");}
					case -8:
						break;
					case 7:
						{ System.out.println ("PAR ABIERTO ");}
					case -9:
						break;
					case 8:
						{ System.out.println ("PAR CERRADO ");}
					case -10:
						break;
					case 9:
						{ System.out.println ("CORCH ABIERTO ");}
					case -11:
						break;
					case 10:
						{ System.out.println ("CORCH CERRADO ");}
					case -12:
						break;
					case 11:
						{ System.out.println ("LLAVE ABIERTA ");}
					case -13:
						break;
					case 12:
						{ System.out.println ("LLAVE CERRADA ");}
					case -14:
						break;
					case 13:
						{ System.out.println ("PUNTO Y COMA ");}
					case -15:
						break;
					case 14:
						{ System.out.println ("DOS PUNTOS ");}
					case -16:
						break;
					case 15:
						{ System.out.println ("IDENTIFICADOR DE VARIABLES ");}
					case -17:
						break;
					case 16:
						{ System.out.println ("MAYOR ");}
					case -18:
						break;
					case 17:
						{ System.out.println ("MENOR");}
					case -19:
						break;
					case 18:
						{ System.out.println ("IGUAL ");}
					case -20:
						break;
					case 19:
						{ System.out.println ("DIFERENCIA ");}
					case -21:
						break;
					case 20:
						{ System.out.println ("DIVISION ");}
					case -22:
						break;
					case 21:
						{ System.out.println ("COMA ");}
					case -23:
						break;
					case 22:
						{ System.out.println ("PUNTO ");}
					case -24:
						break;
					case 23:
						{ System.out.println ("SIGNO MAS ");}
					case -25:
						break;
					case 24:
						{ System.out.println ("SIGNO MENOS ");}
					case -26:
						break;
					case 25:
						{ System.out.println ("SIGNO POR ");}
					case -27:
						break;
					case 26:
						{ System.out.println ("SIGNO DE PORCENTAJE ");}
					case -28:
						break;
					case 27:
						{ System.out.println ("GUION BAJO ");}
					case -29:
						break;
					case 28:
						{ System.out.println ("COMILLA SIMPLE ");}
					case -30:
						break;
					case 29:
						{ }
					case -31:
						break;
					case 30:
						{ System.out.println ("COMENTARIO ");}
					case -32:
						break;
					case 32:
						{ System.out.println ("DO ");}
					case -33:
						break;
					case 33:
						{ System.out.println ("TO ");}
					case -34:
						break;
					case 34:
						{ System.out.println ("OR ");}
					case -35:
						break;
					case 35:
						{ System.out.println ("IN ");}
					case -36:
						break;
					case 36:
						{ System.out.println ("IF ");}
					case -37:
						break;
					case 37:
						{ System.out.println ("COMENTARIOS ");}
					case -38:
						break;
					case 38:
						{yybegin(COMENTARIO);
						 System.out.println("Aqui inicia el esado con /*");
						}
					case -39:
						break;
					case 39:
						{ System.out.println ("AND ");}
					case -40:
						break;
					case 40:
						{ System.out.println ("OR ");}
					case -41:
						break;
					case 41:
						{ System.out.println ("AND ");}
					case -42:
						break;
					case 42:
						{ System.out.println ("SWITCH ");}
					case -43:
						break;
					case 43:
						{ System.out.println ("NEW ");}
					case -44:
						break;
					case 44:
						{ System.out.println ("NOT ");}
					case -45:
						break;
					case 45:
						{ System.out.println ("NIL ");}
					case -46:
						break;
					case 46:
						{ System.out.println ("DIV ");}
					case -47:
						break;
					case 47:
						{ System.out.println ("STD ");}
					case -48:
						break;
					case 48:
						{ System.out.println ("SET ");}
					case -49:
						break;
					case 49:
						{ System.out.println ("TRY ");}
					case -50:
						break;
					case 50:
						{ System.out.println ("END ");}
					case -51:
						break;
					case 51:
						{ System.out.println ("INT ");}
					case -52:
						break;
					case 52:
						{ System.out.println ("FOR ");}
					case -53:
						break;
					case 53:
						{ System.out.println ("VAR ");}
					case -54:
						break;
					case 54:
						{ System.out.println ("ARGS ");}
					case -55:
						break;
					case 55:
						{ System.out.println ("SYNCHRONIZED ");}
					case -56:
						break;
					case 56:
						{ System.out.println ("NULL ");}
					case -57:
						break;
					case 57:
						{ System.out.println ("READ ");}
					case -58:
						break;
					case 58:
						{ System.out.println ("GOTO ");}
					case -59:
						break;
					case 59:
						{ System.out.println ("SHIL ");}
					case -60:
						break;
					case 60:
						{ System.out.println ("THIS ");}
					case -61:
						break;
					case 61:
						{ System.out.println ("BYTE ");}
					case -62:
						break;
					case 62:
						{ System.out.println ("TRUE ");}
					case -63:
						break;
					case 63:
						{ System.out.println ("THIS ");}
					case -64:
						break;
					case 64:
						{ System.out.println ("CASE ");}
					case -65:
						break;
					case 65:
						{ System.out.println ("CATCH ");}
					case -66:
						break;
					case 66:
						{ System.out.println ("COUT ");}
					case -67:
						break;
					case 67:
						{ System.out.println ("CHAR");}
					case -68:
						break;
					case 68:
						{ System.out.println ("ENUM ");}
					case -69:
						break;
					case 69:
						{ System.out.println ("ELSE ");}
					case -70:
						break;
					case 70:
						{ System.out.println ("EXPR ");}
					case -71:
						break;
					case 71:
						{ System.out.println ("LONG ");}
					case -72:
						break;
					case 72:
						{ System.out.println ("UNIT ");}
					case -73:
						break;
					case 73:
						{ System.out.println ("USES ");}
					case -74:
						break;
					case 74:
						{ System.out.println ("WITH ");}
					case -75:
						break;
					case 75:
						{ System.out.println ("INCR ");}
					case -76:
						break;
					case 76:
						{ System.out.println ("VOID ");}
					case -77:
						break;
					case 77:
						{ System.out.println ("PUTS ");}
					case -78:
						break;
					case 78:
						{ System.out.println ("ARRAY ");}
					case -79:
						break;
					case 79:
						{ System.out.println ("AWAIT ");}
					case -80:
						break;
					case 80:
						{ System.out.println ("SUPER ");}
					case -81:
						break;
					case 81:
						{ System.out.println ("SHORT ");}
					case -82:
						break;
					case 82:
						{ System.out.println ("BREAK ");}
					case -83:
						break;
					case 83:
						{ System.out.println ("BEGIN ");}
					case -84:
						break;
					case 84:
						{ System.out.println ("THROW ");}
					case -85:
						break;
					case 85:
						{ System.out.println ("CONST ");}
					case -86:
						break;
					case 86:
						{ System.out.println ("CLASS ");}
					case -87:
						break;
					case 87:
						{ System.out.println ("LABEL ");}
					case -88:
						break;
					case 88:
						{ System.out.println ("UNION ");}
					case -89:
						break;
					case 89:
						{ System.out.println ("YIELD ");}
					case -90:
						break;
					case 90:
						{ System.out.println ("WHILE ");}
					case -91:
						break;
					case 91:
						{ System.out.println ("FALSE ");}
					case -92:
						break;
					case 92:
						{ System.out.println ("FLOAT ");}
					case -93:
						break;
					case 93:
						{ System.out.println ("FINAL ");}
					case -94:
						break;
					case 94:
						{ System.out.println ("ASSERT ");}
					case -95:
						break;
					case 95:
						{ System.out.println ("NATIVE ");}
					case -96:
						break;
					case 96:
						{ System.out.println ("DELETE ");}
					case -97:
						break;
					case 97:
						{ System.out.println ("DOUBLE ");}
					case -98:
						break;
					case 98:
						{ System.out.println ("DOWNTO ");}
					case -99:
						break;
					case 99:
						{ System.out.println ("RETURN ");}
					case -100:
						break;
					case 100:
						{ System.out.println ("STATIC ");}
					case -101:
						break;
					case 101:
						{ System.out.println ("STRUCT ");}
					case -102:
						break;
					case 102:
						{ System.out.println ("STRING ");}
					case -103:
						break;
					case 103:
						{ System.out.println ("SWITCH ");}
					case -104:
						break;
					case 104:
						{ System.out.println ("SIZEOF ");}
					case -105:
						break;
					case 105:
						{ System.out.println ("TYPEOF ");}
					case -106:
						break;
					case 106:
						{ System.out.println ("THROWS ");}
					case -107:
						break;
					case 107:
						{ System.out.println ("EXPORT ");}
					case -108:
						break;
					case 108:
						{ System.out.println ("IMPORT ");}
					case -109:
						break;
					case 109:
						{ System.out.println ("PUBLIC ");}
					case -110:
						break;
					case 110:
						{ System.out.println ("STRING ");}
					case -111:
						break;
					case 111:
						{ System.out.println ("DEFAULT ");}
					case -112:
						break;
					case 112:
						{ System.out.println ("BOOLEAN ");}
					case -113:
						break;
					case 113:
						{ System.out.println ("EXTENDS ");}
					case -114:
						break;
					case 114:
						{ System.out.println ("WRITELN ");}
					case -115:
						break;
					case 115:
						{ System.out.println ("VIRTUAL ");}
					case -116:
						break;
					case 116:
						{ System.out.println ("PACKAGE ");}
					case -117:
						break;
					case 117:
						{ System.out.println ("PROGRAM ");}
					case -118:
						break;
					case 118:
						{ System.out.println ("PRIVATE ");}
					case -119:
						break;
					case 119:
						{ System.out.println ("FINALLY ");}
					case -120:
						break;
					case 120:
						{ System.out.println ("INCLUDE ");}
					case -121:
						break;
					case 121:
						{ System.out.println ("ABSTRACT ");}
					case -122:
						break;
					case 122:
						{ System.out.println ("ABSOLUTE ");}
					case -123:
						break;
					case 123:
						{ System.out.println ("DEBUGGER ");}
					case -124:
						break;
					case 124:
						{ System.out.println ("STRICTFP ");}
					case -125:
						break;
					case 125:
						{ System.out.println ("ABSTRACT ");}
					case -126:
						break;
					case 126:
						{ System.out.println ("FUNCTION ");}
					case -127:
						break;
					case 127:
						{ System.out.println ("VOLATILE ");}
					case -128:
						break;
					case 128:
						{ System.out.println ("TRANSIENT ");}
					case -129:
						break;
					case 129:
						{ System.out.println ("INTERFACE ");}
					case -130:
						break;
					case 130:
						{ System.out.println ("PROTECTED ");}
					case -131:
						break;
					case 131:
						{ System.out.println ("DESTRUCTOR ");}
					case -132:
						break;
					case 132:
						{ System.out.println ("INSTANCEOF ");}
					case -133:
						break;
					case 133:
						{ System.out.println ("IOSTREAM ");}
					case -134:
						break;
					case 134:
						{ System.out.println ("SYNCHRONIZED ");}
					case -135:
						break;
					case 135:
						{ System.out.println ("IMPRIMIR ");}
					case -136:
						break;
					case 136:
						{}
					case -137:
						break;
					case 137:
						{System.out.println ("Una linea de comentario");}
					case -138:
						break;
					case 138:
						{}
					case -139:
						break;
					case 139:
						{yybegin(YYINITIAL);
						System.out.println ("Aqui Termina el comentario con */");
						}
					case -140:
						break;
					case 140:
						{ System.out.println ("NUMERO ");}
					case -141:
						break;
					case 141:
						{ System.out.println ("LETRA ");}
					case -142:
						break;
					case 142:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -143:
						break;
					case 143:
						{ System.out.println ("COMENTARIO ");}
					case -144:
						break;
					case 145:
						{ System.out.println ("LETRA ");}
					case -145:
						break;
					case 146:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -146:
						break;
					case 148:
						{ System.out.println ("LETRA ");}
					case -147:
						break;
					case 149:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -148:
						break;
					case 151:
						{ System.out.println ("LETRA ");}
					case -149:
						break;
					case 153:
						{ System.out.println ("LETRA ");}
					case -150:
						break;
					case 155:
						{ System.out.println ("LETRA ");}
					case -151:
						break;
					case 157:
						{ System.out.println ("LETRA ");}
					case -152:
						break;
					case 159:
						{ System.out.println ("LETRA ");}
					case -153:
						break;
					case 161:
						{ System.out.println ("LETRA ");}
					case -154:
						break;
					case 163:
						{ System.out.println ("LETRA ");}
					case -155:
						break;
					case 165:
						{ System.out.println ("LETRA ");}
					case -156:
						break;
					case 167:
						{ System.out.println ("LETRA ");}
					case -157:
						break;
					case 169:
						{ System.out.println ("LETRA ");}
					case -158:
						break;
					case 171:
						{ System.out.println ("LETRA ");}
					case -159:
						break;
					case 173:
						{ System.out.println ("LETRA ");}
					case -160:
						break;
					case 175:
						{ System.out.println ("LETRA ");}
					case -161:
						break;
					case 177:
						{ System.out.println ("LETRA ");}
					case -162:
						break;
					case 179:
						{ System.out.println ("LETRA ");}
					case -163:
						break;
					case 181:
						{ System.out.println ("LETRA ");}
					case -164:
						break;
					case 183:
						{ System.out.println ("LETRA ");}
					case -165:
						break;
					case 346:
						{ System.out.println ("LETRA ");}
					case -166:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
