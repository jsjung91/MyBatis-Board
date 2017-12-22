package vo;

public class BoardVo {

	int no;
	int idx,readhit,ref,step,depth;
	String name,subject,content,pwd,ip,regdate,chk_info;
	
	public BoardVo(){}
	
	public BoardVo(String name, String subject, String content, String pwd, String chk_info, String ip) {
		super();
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
		this.chk_info = chk_info;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getChk_info() {
		return chk_info;
	}
	public void setChk_info(String chk_info) {
		this.chk_info = chk_info;
	}
	
	
}
