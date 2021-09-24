package uk.ac.herc.iminds.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Participant.
 */
@Entity
@Table(name = "participant")
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "participant_id", nullable = false, unique = true)
    private String participantId;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private UniqueCode uniqueCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Participant id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantId() {
        return this.participantId;
    }

    public Participant participantId(String participantId) {
        this.setParticipantId(participantId);
        return this;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public UniqueCode getUniqueCode() {
        return this.uniqueCode;
    }

    public void setUniqueCode(UniqueCode uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public Participant uniqueCode(UniqueCode uniqueCode) {
        this.setUniqueCode(uniqueCode);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Participant)) {
            return false;
        }
        return id != null && id.equals(((Participant) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Participant{" +
            "id=" + getId() +
            ", participantId='" + getParticipantId() + "'" +
            "}";
    }
}
