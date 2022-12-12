package com.warehouse.common;

public class Constants {

    private Constants() {
    }

    public static final String DOT = ".";
    public static final String FILE_CSV = "csv";
    public static final String PDF = "application/pdf";
    public static final String TYPE_CSV = "text/csv";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String LOG_PATH_BASE = "src\\main\\resources\\log\\log_";

    // status code response
    public static final int HTTP_CODE_200 = 200;
    public static final int HTTP_CODE_409 = 409;
    public static final int HTTP_CODE_400 = 400;
    public static final int HTTP_CODE_401 = 401;
    public static final int HTTP_CODE_403 = 403;
    public static final int HTTP_CODE_404 = 404;
    public static final int HTTP_CODE_500 = 500;
    public static final int HTTP_CODE_10101 = 10101;

    // Flag
    public static final Boolean DELETE_TRUE = true;
    public static final Boolean DELETE_FALSE = false;
    public static final Boolean AVAILABILITY_TRUE = true;
    public static final Boolean AVAILABILITY_FALSE = false;

    // status response
    public static final Integer COMPLETED = 1;
    public static final Integer NONE_COMPLETE = 0;

    public static final String PASSWORD_WAREHOUSE_DE = "baldr_sky_dive";

    public static final String DELETE_SUCCESS = "Record deleted successfully";
    public static final String CREATE_SUCCESS = "Record create successfully";
    public static final String UPDATE_SUCCESS = "Record update successfully";
    public static final String SUCCESS = "Success get information record";
    public static final String ERROR = "Server error";
    public static final String RECORD_NOT_FOUND_DATA = "Data record not found";
    public static final String RECORD_NOT_FOUND = "%s record not found";
    public static final String USER_NAME_OR_PASSWORD_ERROR = "Username or password incorrect";
    public static final String DUPLICATE_EXCEPTION = "%s already exist";
    public static final String CONFLICT = "Record already exist";
    public static final String LOGGED_OUT_SUCCESS = "User has successfully logged out from the system!";
    public static final String SEND_MAIL_SUCCESS = "Send mail success";
    public static final String MAIL_NOT_CHANGE_PASSWORD = "Cant change password this email";

    public static final String VALIDATE_THE_FIELD = "The field can't empty";
    public static final String VALIDATE_MAX_SIZE_2 = "No more than 2 characters";
    public static final String VALIDATE_MAX_SIZE_3 = "No more than 3 characters";
    public static final String VALIDATE_MAX_SIZE_4 = "No more than 4 characters";
    public static final String VALIDATE_MAX_SIZE_5 = "No more than 5 characters";

    public static final String VALIDATE_MAX_SIZE_6 = "No more than 6 characters";
    public static final String VALIDATE_MAX_SIZE_7 = "No more than 7 characters";

    public static final String VALIDATE_MAX_SIZE_10 = "No more than 10 characters";
    public static final String VALIDATE_MAX_SIZE_12 = "No more than 12 characters";
    public static final String VALIDATE_MAX_SIZE_13 = "No more than 13 characters";
    public static final String VALIDATE_MAX_SIZE_20 = "No more than 20 characters";
    public static final String VALIDATE_MAX_SIZE_30 = "No more than 30 characters";
    public static final String VALIDATE_MAX_SIZE_32 = "No more than 32 characters";
    public static final String VALIDATE_MAX_SIZE_40 = "No more than 40 characters";
    public static final String VALIDATE_MAX_SIZE_50 = "No more than 50 characters";
    public static final String VALIDATE_MAX_SIZE_60 = "No more than 60 characters";
    public static final String VALIDATE_MAX_SIZE_64 = "No more than 64 characters";
    public static final String VALIDATE_MAX_SIZE_120 = "No more than 120 characters";
    public static final String VALIDATE_MAX_SIZE_128 = "No more than 128 characters";
    public static final String VALIDATE_MAX_SIZE_200 = "No more than 200 characters";
    public static final String VALIDATE_MAX_SIZE_250 = "No more than 250 characters";
    public static final String FIELD_NOT_VALID = "field not valid";

    // max page
    public static final Integer RESULTS_PER_PAGE = 15;

    // symbol
    public static final String SEARCH_LIKE = "%";

    public static final String OFF_SET_LIMIT = "\nOFFSET %s LIMIT 50";
    public static final String SELECT_COUNT = "SELECT COUNT(*)\n";

    // maxlength
    public static final int MAX_2 = 2;
    public static final int MAX_3 = 3;
    public static final int MAX_4 = 4;
    public static final int MAX_5 = 5;
    public static final int MAX_6 = 6;
    public static final int MAX_7 = 7;
    public static final int MAX_8 = 8;
    public static final int MAX_10 = 10;
    public static final int MAX_12 = 12;
    public static final int MAX_13 = 13;
    public static final int MAX_15 = 15;
    public static final int MAX_20 = 20;
    public static final int MAX_30 = 30;
    public static final int MAX_32 = 32;
    public static final int MAX_40 = 40;
    public static final int MAX_50 = 50;
    public static final int MAX_60 = 60;
    public static final int MAX_64 = 64;
    public static final int MAX_120 = 120;
    public static final int MAX_200 = 200;
    public static final int MAX_128 = 128;
    public static final int MAX_250 = 250;
    public static final int MAX_2000 = 2000;

    // Date Format
    public static final String DATE_FORMAT = "yyyy-MM-dd";
}
