package model;


public class IdealException extends Exception {
	private static final long serialVersionUID = 1L;

	private int errCd;
	private final static String ERR_MSG[] = {
		"障害が発生しました。",
		"データベース処理で例外が発生しました。",
		"お客様ID、パスワードを確認してください。",
		"管理者名、パスワードを確認してください。",
		"ご指定された日時に、空席がございませんでした。",
		"予約されているコースなので削除できません。",
		"コースに登録されているメニューなので削除できません。"
	};

	public final static int ERR_NO_EXCEPTION= 0;
	public final static int ERR_NO_DB_EXCEPTION = 1;
	public final static int ERR_NO_NOT_MEMBER_EXCEPTION = 2;
	public final static int ERR_NO_ADMIN_EXCEPTION = 3;
	public final static int ERR_NOT_NOT_VACANCY = 4;
	public final static int ERR_NOT_NOT_RESERV_DELETE = 5;
	public final static int ERR_NOT_NOT_MENU_DELETE = 6;

	public int getErrCd() {
		return errCd;
	}

	public void setErrCd(int errCd) {
		this.errCd = errCd;
	}

	public static String[] getErrMsg() {
		return ERR_MSG;
	}

	//コンストラクター
	public IdealException() {
		super();
	}

	public IdealException(int errCd) {
		this.errCd = errCd;
	}

	public String getMsg() {
		return ERR_MSG[this.getErrCd()];

	}


	}
