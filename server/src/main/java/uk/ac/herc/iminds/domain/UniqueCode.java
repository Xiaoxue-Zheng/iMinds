package uk.ac.herc.iminds.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;
import uk.ac.herc.iminds.domain.enumeration.AppType;
import uk.ac.herc.iminds.domain.enumeration.UniqueCodeStatus;

/**
 * A UniqueCode.
 */
@Entity
@Table(name = "unique_code")
public class UniqueCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "device_id")
    private String deviceId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "app_type", nullable = false)
    private AppType appType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UniqueCodeStatus status;

    @NotNull
    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public UniqueCode id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public UniqueCode code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public UniqueCode deviceId(String deviceId) {
        this.setDeviceId(deviceId);
        return this;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public AppType getAppType() {
        return this.appType;
    }

    public UniqueCode appType(AppType appType) {
        this.setAppType(appType);
        return this;
    }

    public void setAppType(AppType appType) {
        this.appType = appType;
    }

    public UniqueCodeStatus getStatus() {
        return this.status;
    }

    public UniqueCode status(UniqueCodeStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(UniqueCodeStatus status) {
        this.status = status;
    }

    public Instant getCreateTime() {
        return this.createTime;
    }

    public UniqueCode createTime(Instant createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueCode)) {
            return false;
        }
        return id != null && id.equals(((UniqueCode) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UniqueCode{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", deviceId='" + getDeviceId() + "'" +
            ", appType='" + getAppType() + "'" +
            ", status='" + getStatus() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}
