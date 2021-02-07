package enities.football;

import enities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="result_predictions")
public class ResultPrediction extends BaseEntity {
    private PredictionEnum prediction;

    public ResultPrediction() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "prediction")
    public PredictionEnum getPrediction() {
        return prediction;
    }

    public void setPrediction(PredictionEnum prediction) {
        this.prediction = prediction;
    }
}
