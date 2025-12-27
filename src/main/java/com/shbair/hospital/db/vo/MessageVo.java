
package com.shbair.hospital.db.vo;

import java.sql.Date;
import javax.print.attribute.DateTimeSyntax;

/**
 *
 * @author LCS
 */
public class MessageVo {
    private int id;
    private  String messageBody;
    private Date messageDate;
    private UsersVo fromUser;
    private UsersVo toUser;
    private PatientinfoVo patientinfoVo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public UsersVo getFromUser() {
        return fromUser;
    }

    public void setFromUser(UsersVo fromUser) {
        this.fromUser = fromUser;
    }

    public UsersVo getToUser() {
        return toUser;
    }

    public void setToUser(UsersVo toUser) {
        this.toUser = toUser;
    }

    public PatientinfoVo getPatientinfoVo() {
        return patientinfoVo;
    }

    public void setPatientinfoVo(PatientinfoVo patientinfoVo) {
        this.patientinfoVo = patientinfoVo;
    }
           
}
