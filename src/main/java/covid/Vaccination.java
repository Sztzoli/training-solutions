package covid;

import java.time.LocalDateTime;

public class Vaccination {

    private Long id;
    private Long citizenId;
    private LocalDateTime vaccinationDate;
    private VaccinationStatus status;
    private String note;
    private VaccinationType vaccinationType;

    public Vaccination(Long id, Long citizenId, LocalDateTime vaccinationDate, VaccinationStatus status, String note, VaccinationType vaccinationType) {
        this.id = id;
        this.citizenId = citizenId;
        this.vaccinationDate = vaccinationDate;
        this.status = status;
        this.note = note;
        this.vaccinationType = vaccinationType;
    }

    public Vaccination(Long citizenId, LocalDateTime vaccinationDate, VaccinationStatus status, String note, VaccinationType vaccinationType) {
        this.citizenId = citizenId;
        this.vaccinationDate = vaccinationDate;
        this.status = status;
        this.note = note;
        this.vaccinationType = vaccinationType;
    }

    public Vaccination() {
    }

    public static Vaccination vaccinationSuccess(Long  citizenId, LocalDateTime vaccination_date, VaccinationType vaccination_type){
        Vaccination vaccination = new Vaccination();
        vaccination.setCitizenId(citizenId);
        vaccination.setVaccinationDate(vaccination_date);
        vaccination.setVaccinationType(vaccination_type);
        vaccination.setStatus(VaccinationStatus.SUCCES);
        return vaccination;
    }

    public static Vaccination vaccinationFail(Long  citizenId, LocalDateTime vaccination_date, String note){
        Vaccination vaccination = new Vaccination();
        vaccination.setCitizenId(citizenId);
        vaccination.setVaccinationDate(vaccination_date);
        vaccination.setStatus(VaccinationStatus.FAIL);
        vaccination.setNote(note);
        return vaccination;
    }



    public Long getId() {
        return id;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public LocalDateTime getVaccinationDate() {
        return vaccinationDate;
    }

    public VaccinationStatus getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccinationType getVaccinationType() {
        return vaccinationType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public void setVaccinationDate(LocalDateTime vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public void setStatus(VaccinationStatus status) {
        this.status = status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setVaccinationType(VaccinationType vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "id=" + id +
                ", citizenId=" + citizenId +
                ", vaccination_date=" + vaccinationDate +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", vaccination_type='" + vaccinationType + '\'' +
                '}';
    }
}
