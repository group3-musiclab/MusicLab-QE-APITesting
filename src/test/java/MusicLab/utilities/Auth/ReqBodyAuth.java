package MusicLab.utilities.Auth;

import MusicLab.Base;

public class ReqBodyAuth extends Base {
    public static final String REQ_BODY = JSON_REQ_BODY_USER + "Auth/";
    public static final String MENTOR = REQ_BODY + "login_mentor.json";
    public static final String REGIS_MENTOR = REQ_BODY + "register_mentor.json";
    public static final String REGIS_MENTOR_INVALID = REQ_BODY + "register_mentor_invalid.json";
    public static final String REGIS_MENTOR_BLANK = REQ_BODY + "register_mentor_blank.json";
    public static final String MENTOR_INVALID = REQ_BODY + "login_mentor_invalid.json";
    public static final String MENTOR_BLANK = REQ_BODY + "login_mentor_blank.json";
    public static final String STUDENT = REQ_BODY + "login_student.json";
    public static final String REGIS_STUDENT = REQ_BODY + "register_student.json";
    public static final String REGIS_STUDENT_INVALID = REQ_BODY + "register_student_invalid.json";
    public static final String REGIS_STUDENT_BLANK = REQ_BODY + "register_student_blank.json";
    public static final String STUDENT_INVALID = REQ_BODY + "login_student_invalid.json";
    public static final String STUDENT_BLANK = REQ_BODY + "login_student_blank.json";
}
