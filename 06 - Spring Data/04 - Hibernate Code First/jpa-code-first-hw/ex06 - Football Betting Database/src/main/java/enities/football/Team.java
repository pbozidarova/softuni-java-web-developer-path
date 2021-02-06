package enities.football;

import enities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;

@Entity
@Table(name="teams")
public class Team extends BaseEntity {
    private String name;
    private byte[] logo;
    private String threeLetterInitials;
    private Color primaryKitColor;
    private Color secondaryKitColor;
    private Town town;
    private BigDecimal budget;

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    @Lob
    @Column(name = "logo")
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }


    @Column(name="three_letter_initials", length = 3)
    public String getThreeLetterInitials() {
        return threeLetterInitials;
    }

    public Team setThreeLetterInitials(String threeLetterInitials) {
        this.threeLetterInitials = threeLetterInitials;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="primary_kit_color_id", referencedColumnName = "id")
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public Team setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="secondary_kit_color_id", referencedColumnName = "id")
    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public Team setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="town_id", referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public Team setTown(Town town) {
        this.town = town;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Team setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
