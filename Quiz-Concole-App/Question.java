public class Question {
    private int id;
    private String question;
    private String opt1;
    private String otp2;
    private String otp3;
    private String otp4;
    private String answer;

    public Question() {
    }

    public Question(int id ,String question, String opt1, String otp2, String otp3, String otp4 ,String answer) {
        this.answer = answer;
        this.id = id;
        this.opt1 = opt1;
        this.otp2 = otp2;
        this.otp3 = otp3;
        this.otp4 = otp4;
        this.question = question;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOtp2() {
        return otp2;
    }

    public void setOtp2(String otp2) {
        this.otp2 = otp2;
    }

    public String getOtp3() {
        return otp3;
    }

    public void setOtp3(String otp3) {
        this.otp3 = otp3;
    }

    public String getOtp4() {
        return otp4;
    }

    public void setOtp4(String otp4) {
        this.otp4 = otp4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question{");
        sb.append("id=").append(id);
        sb.append(", question=").append(question);
        sb.append(", opt1=").append(opt1);
        sb.append(", otp2=").append(otp2);
        sb.append(", otp3=").append(otp3);
        sb.append(", otp4=").append(otp4);
        sb.append(", answer=").append(answer);
        sb.append('}');
        return sb.toString();
    }

}
