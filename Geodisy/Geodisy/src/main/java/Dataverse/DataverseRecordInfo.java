package Dataverse;

import java.io.Serializable;

public class DataverseRecordInfo implements Serializable {
    private int major;
    private int minor;
    private String doi;

    public DataverseRecordInfo() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof DataverseRecordInfo))
            return false;
        if (obj == this)
            return true;
        Boolean equals = this.getMajor()==((DataverseRecordInfo) obj).getMajor()
                && this.getMinor()==((DataverseRecordInfo) obj).getMinor();
        return equals;
    }

    public boolean younger(Object obj) {
        if (obj == null) return true;
        if (obj == this)
            return false;
        Boolean younger = this.getMajor() >((DataverseRecordInfo) obj).getMajor() || (this.getMajor()==((DataverseRecordInfo) obj).getMajor() && this.getMinor() >((DataverseRecordInfo) obj).getMinor());

        return younger;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public String getDoi() {
        return doi;
    }

    @Override
    public int hashCode()
    {
        int prime = 31;
        return prime + (doi == null ? 0 : doi.hashCode());
    }

    public void setMajor(int major) {
        this.major = major;
    }
    public void setMajor(String major){
        this.major = Integer.parseInt(major);
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public void setMinor(String minor){this.minor = Integer.parseInt(minor);}

    public void setDoi(String doi) {
        this.doi = doi;
    }

}
