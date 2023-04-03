package MusicLab.utilities.Genre;

import MusicLab.Base;

public class ReqBodyGenre extends Base {
    public static final String REQ_BODY = JSON_REQ_BODY_USER + "Genre/";
    public static final String POST = REQ_BODY + "post_genres.json";
    public static final String POST_INVALID = REQ_BODY + "post_genres_invalid.json";
    public static final String POST_BLANK = REQ_BODY + "post_genres_blank.json";
}