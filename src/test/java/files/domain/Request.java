package files.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class Request {
    private String ssylka;
    private String citizenship;
    private Boolean fl;
    private Integer seriya;
    private Integer nomer;
    private String familiya;
    private String imya;
    private String otchestvo;
    private String nomerSvidetelstva;
    private String email;
    private List<File> files;

    public String getSsylka() {
        return ssylka;
    }

    public void setSsylka(String ssylka) {
        this.ssylka = ssylka;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public Boolean getFl() {
        return fl;
    }

    public void setFl(Boolean fl) {
        this.fl = fl;
    }

    public Integer getSeriya() {
        return seriya;
    }

    public void setSeriya(Integer seriya) {
        this.seriya = seriya;
    }

    public Integer getNomer() {
        return nomer;
    }

    public void setNomer(Integer nomer) {
        this.nomer = nomer;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getNomerSvidetelstva() {
        return nomerSvidetelstva;
    }

    public void setNomerSvidetelstva(String nomerSvidetelstva) {
        this.nomerSvidetelstva = nomerSvidetelstva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Request{" +
                "ssylka='" + ssylka + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", fl=" + fl +
                ", seriya=" + seriya +
                ", nomer=" + nomer +
                ", familiya='" + familiya + '\'' +
                ", imya='" + imya + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                ", nomerSvidetelstva='" + nomerSvidetelstva + '\'' +
                ", email='" + email + '\'' +
                ", files=" + files +
                '}';
    }

    public static class File {
        private String file_name;
        private String file_data;

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getFile_data() {
            return file_data;
        }

        public void setFile_data(String file_data) {
            this.file_data = file_data;
        }

        @Override
        public String toString() {
            return "File{" +
                    "file_name='" + file_name + '\'' +
                    ", file_data='" + file_data + '\'' +
                    '}';
        }
    }
}
