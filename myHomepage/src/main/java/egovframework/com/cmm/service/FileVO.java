package egovframework.com.cmm.service;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * @Class Name : FileVO.java
 * @Description : 파일정보 처리를 위한 VO 클래스
 * @Modification Information
 *
 *               수정일 수정자 수정내용 ------- ------- ------------------- 2009. 3. 25.
 *               이삼섭
 *
 * @author 공통 서비스 개발팀 이삼섭	
 * @since 2009. 3. 25.
 * @version
 * @see
 *
 */
@Alias("FileVO")
public class FileVO implements Serializable {

	/**
	 * serialVersion UID
	 */
	private static final long serialVersionUID = -287950405903719128L;
	/**
	 * 첨부파일 아이디
	 */
	public String atch_file_id = "";
	/**
	 * 생성일자
	 */
	public String creat_dt = "";
	/**
	 * 파일내용
	 */
	public String file_cn= "";
	/**
	 * 파일확장자
	 */
	public String file_extsn = "";
	/**
	 * 파일크기
	 */
	public String file_mg = "";
	/**
	 * 파일연번
	 */
	public String file_sn = "";
	/**
	 * 파일저장경로
	 */
	public String file_stre_cours = "";
	/**
	 * 원파일명
	 */
	public String orignl_file_nm = "";
	/**
	 * 저장파일명
	 */
	public String stre_file_nm = "";

	public FileVO() {
		
	}

	public String getAtch_file_id() {
		return atch_file_id;
	}

	public void setAtch_file_id(String atch_file_id) {
		this.atch_file_id = atch_file_id;
	}

	public String getCreat_dt() {
		return creat_dt;
	}

	public void setCreat_dt(String creat_dt) {
		this.creat_dt = creat_dt;
	}

	public String getFile_cn() {
		return file_cn;
	}

	public void setFile_cn(String file_cn) {
		this.file_cn = file_cn;
	}

	public String getFile_mg() {
		return file_mg;
	}

	public void setFile_mg(String file_mg) {
		this.file_mg = file_mg;
	}

	public String getFile_sn() {
		return file_sn;
	}

	public void setFile_sn(String file_sn) {
		this.file_sn = file_sn;
	}

	public String getFile_stre_cours() {
		return file_stre_cours;
	}

	public void setFile_stre_cours(String file_stre_cours) {
		this.file_stre_cours = file_stre_cours;
	}

	public String getOrignl_file_nm() {
		return orignl_file_nm;
	}

	public void setOrignl_file_nm(String orignl_file_nm) {
		this.orignl_file_nm = orignl_file_nm;
	}

	public String getStre_file_nm() {
		return stre_file_nm;
	}

	public void setStre_file_nm(String stre_file_nm) {
		this.stre_file_nm = stre_file_nm;
	}

	public FileVO(String atch_file_id) {
		super();
		this.atch_file_id = atch_file_id;
	}

	public String getFile_extsn() {
		return file_extsn;
	}

	public void setFile_extsn(String file_extsn) {
		this.file_extsn = file_extsn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atch_file_id == null) ? 0 : atch_file_id.hashCode());
		result = prime * result + ((creat_dt == null) ? 0 : creat_dt.hashCode());
		result = prime * result + ((file_cn == null) ? 0 : file_cn.hashCode());
		result = prime * result + ((file_extsn == null) ? 0 : file_extsn.hashCode());
		result = prime * result + ((file_mg == null) ? 0 : file_mg.hashCode());
		result = prime * result + ((file_sn == null) ? 0 : file_sn.hashCode());
		result = prime * result + ((file_stre_cours == null) ? 0 : file_stre_cours.hashCode());
		result = prime * result + ((orignl_file_nm == null) ? 0 : orignl_file_nm.hashCode());
		result = prime * result + ((stre_file_nm == null) ? 0 : stre_file_nm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileVO other = (FileVO) obj;
		if (atch_file_id == null) {
			if (other.atch_file_id != null)
				return false;
		} else if (!atch_file_id.equals(other.atch_file_id))
			return false;
		if (creat_dt == null) {
			if (other.creat_dt != null)
				return false;
		} else if (!creat_dt.equals(other.creat_dt))
			return false;
		if (file_cn == null) {
			if (other.file_cn != null)
				return false;
		} else if (!file_cn.equals(other.file_cn))
			return false;
		if (file_extsn == null) {
			if (other.file_extsn != null)
				return false;
		} else if (!file_extsn.equals(other.file_extsn))
			return false;
		if (file_mg == null) {
			if (other.file_mg != null)
				return false;
		} else if (!file_mg.equals(other.file_mg))
			return false;
		if (file_sn == null) {
			if (other.file_sn != null)
				return false;
		} else if (!file_sn.equals(other.file_sn))
			return false;
		if (file_stre_cours == null) {
			if (other.file_stre_cours != null)
				return false;
		} else if (!file_stre_cours.equals(other.file_stre_cours))
			return false;
		if (orignl_file_nm == null) {
			if (other.orignl_file_nm != null)
				return false;
		} else if (!orignl_file_nm.equals(other.orignl_file_nm))
			return false;
		if (stre_file_nm == null) {
			if (other.stre_file_nm != null)
				return false;
		} else if (!stre_file_nm.equals(other.stre_file_nm))
			return false;
		return true;
	}
}
