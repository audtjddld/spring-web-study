package egovframework.com.cmm;

import java.io.Serializable;

import com.study.myhome.user.service.UserAuthorityVO;

/**
 * @Class Name : LoginVO.java
 * @Description : Login VO class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ ------- --------
 *               --------------------------- @ 2009.03.03 박지욱 최초 생성
 *
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.03
 * @version 1.0
 * @see
 * 
 */
public class LoginVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;

	/** 아이디 */
	private String username;
	/** 비밀번호 */
	private String password;
	/** 사용자 권한 **/
	private UserAuthorityVO userAuthority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserAuthorityVO getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthorityVO userAuthority) {
		this.userAuthority = userAuthority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginVO() {

	}

	public LoginVO(String username, String password, String userSe,
			UserAuthorityVO userAuthority) {
		super();
		this.username = username;
		this.password = password;
		this.userAuthority = userAuthority;
	}

}
