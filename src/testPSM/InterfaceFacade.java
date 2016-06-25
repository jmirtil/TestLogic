package testPSM;

import PSM_Logic.LogicFacade;


public class InterfaceFacade {
	private static int course;
	private String username;
	private String password;
	private boolean ack;
	
	private boolean edit;
	private boolean logout;
	private boolean init;
	
	public static String defSub = "";
	public static String defSemester = "";
    public static String defCourseName = "";
    public String defCourseStart = "";
    public static String defCourseEnd = "";
    public static String defMonStart = "";
    public static String defMonEnd = "";
    public static String defTueStart = "";
    public static String defTueEnd = "";
    public static String defWedStart = "";
    public static String defWedEnd = "";
    public static String defThuStart = "";
    public static String defThuEnd = "";
    public static String defFriStart = "";
    public static String defFriEnd = "";
    public static String defSatStart = "";
    public static String defSatEnd = "";
    
	public InterfaceFacade() {
		username = "";
		password = "";
	}

	public void testHelper( String courseSubj, String courseName, String semester,
            String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat){
		defSub = courseSubj;
		defCourseName = courseName;
		defSemester = semester;
		defCourseStart = startDate;
		defCourseEnd = endDate;
		defMonStart = startMon;
		defMonEnd = endMon;
		defTueStart = startTue;
		defTueEnd = endTue;
		defWedStart = startWed;
		defWedEnd = endWed;
		defThuStart = startThu;
		defThuEnd = endThu;
		defFriStart = startFri;
		defFriEnd = endFri;
		defSatStart = startSat;
		defSatEnd = endSat;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setLogout(boolean logout) {
		this.logout = logout;
	}

	public void setInit(boolean init) {
		this.init = init;
	}
	public void setUsername(String u){
		username = u;
	}
	public void setPassword(String p){
		password = p;
	}
	
	public void lockedOut(){
		//do nothing
	}
	
	public void logoutConfirmation(){
		//do nothing
	}
	
	public void launchLogout(){
		//do nothing
	}
	
	public void incorrectLogin(){
		//do nothing
	}
	
	public void launchInitial(){
		//do nothing
	}
	
	public void launchEdit(int courseID, String courseSubj, String courseName, String semester,
            String startDate, String endDate, String startMon, String endMon,
            String startTue, String endTue, String startWed, String endWed, String startThu, String endThu, 
            String startFri, String endFri, String startSat, String endSat){
		//do nothing
	}
	
	public void launchCourse(){
		//do nothing
	}
	
	public void launchLoginForm(){
		//do nothing
	}
	
	public void launchMenu(){
		//do nothing
	}
	
	public boolean menuDataRec(){
		return true;
	}
	
	public void setMenuDataRec(boolean bool){
		//do nothing
	}
	
	public boolean schedDataRec(){
		return true;
	}
	
	public void setSchedDataRec(boolean bool){
		//do nothing
	}
	
	public boolean courseSelected(){
		return true;
	}
	
	public void setCourseSelected(boolean bool){
		//true
	}
	
	public int getSelection(){
		return course;
	}
	public void setCourse(int courseID){
		course = courseID;
	}
	
	public boolean psDataRec(){
		return true;
	}
	
	public void setPsDataRec(boolean bool){
		//do nothing
	}
	
	public boolean dataReceived(){
		return true;
	}
	
	public void setLogDataRec(boolean bool){
		//do nothing
	}
	
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public boolean getAck(){
		return true;
	}
	
	public boolean editSchedSelected(){
		return edit;
	}
	
	public boolean InitSetupSelected(){
		return init;
	}
	
	public boolean logoutSelected(){
		return logout;
	}
	public void setDefSub(String defSub) {
		this.defSub = defSub;
	}

	public void setDefSemester(String defSemester) {
		this.defSemester = defSemester;
	}

	public void setDefCourseName(String defCourseName) {
		this.defCourseName = defCourseName;
	}
	public void setDefCourseStart(String defCourseStart) {
		this.defCourseStart = defCourseStart;
	}

	public void setDefCourseEnd(String defCourseEnd) {
		this.defCourseEnd = defCourseEnd;
	}

	public void setDefMonStart(String defMonStart) {
		this.defMonStart = defMonStart;
	}

	public void setDefMonEnd(String defMonEnd) {
		this.defMonEnd = defMonEnd;
	}

	public void setDefTueStart(String defTueStart) {
		this.defTueStart = defTueStart;
	}

	public void setDefTueEnd(String defTueEnd) {
		this.defTueEnd = defTueEnd;
	}

	public void setDefWedStart(String defWedStart) {
		this.defWedStart = defWedStart;
	}

	public void setDefWedEnd(String defWedEnd) {
		this.defWedEnd = defWedEnd;
	}

	public void setDefThuStart(String defThuStart) {
		this.defThuStart = defThuStart;
	}

	public void setDefThuEnd(String defThuEnd) {
		this.defThuEnd = defThuEnd;
	}

	public void setDefFriStart(String defFriStart) {
		this.defFriStart = defFriStart;
	}

	public void setDefFriEnd(String defFriEnd) {
		this.defFriEnd = defFriEnd;
	}

	public void setDefSatStart(String defSatStart) {
		this.defSatStart = defSatStart;
	}

	public void setDefSatEnd(String defSatEnd) {
		this.defSatEnd = defSatEnd;
	}
	
	public String getNewCourseStart(){ 
		return defCourseStart;
	}
	
	public String getpNewCourseStart(){ 
		return defCourseStart;
	}
	
	
	public int getDefCourseID() {
		return course;
	}
	
	public String getpNewCourseEnd() {
		return defCourseEnd;
	}
	
	public String getpNewMonStart() {
		return defMonStart;
	}
	
	public String getpNewTueStart() {
		return defTueStart;
	}
	
	public String getpNewTueEnd() {
		return defTueEnd;
	}
	
	public String getpNewThuEnd() {
		return defThuEnd;
	}
	
	public String getpNewThuStart() {
		return defThuStart;
	}
	
	public String getpNewWedEnd() {
		return defWedEnd;
	}
	
	public String getpNewWedStart() {
		return defWedStart;
	}
	
	public String getpNewFriEnd() {
		return defFriEnd;
	}
	
	public String getpNewSatEnd() {
		return defSatEnd;
	}
	
	public String getpNewSatStart() {
		return defSatStart;
	}
	
	public String getpNewFriStart() {
		return defFriStart;
	}
	
	public String getpNewMonEnd() {
		return defMonEnd;
	}
	
	public int getNewCourseID() {
		return course;
	}
	
	public String getNewSub() {
		return defSub;
	}
	
	public String getNewCourseName() {
		return defCourseName;
	}
	
	public String getNewSemester() {
		return defSemester;
	}
	
	public String getNewCourseEnd() {
		return defCourseEnd;
	}
	
	public String getNewMonStart() {
		return defMonStart;
	}
	
	public String getNewTueStart() {
		return defTueStart;
	}
	
	public String getNewTueEnd() {
		return defTueEnd;
	}
	
	public String getNewThuEnd() {
		return defThuEnd;
	}
	
	public String getNewThuStart() {
		return defThuStart;
	}
	
	public String getNewWedEnd() {
		return defWedEnd;
	}
	
	public String getNewWedStart() {
		return defWedStart;
	}
	
	public String getNewFriEnd() {
		return defFriEnd;
	}
	
	public String getNewSatEnd() {
		return defSatEnd;
	}
	
	public String getNewSatStart() {
		return defSatStart;
	}
	
	public String getNewFriStart() {
		return defFriStart;
	}
	
	public String getNewMonEnd() {
		return defMonEnd;
	}

	public void setAck(boolean b) {
		ack = b;
	}

	public void FifteenMinWarning() {
		//do nothing
		
	}

	public void FiveMinWarning() {
		//do nothing
	}

	public void endClassWarning() {
		//do nothing
	}

	public void initiate(LogicFacade logicFacade) {
		//do nothing
		
	}
	
	
}
