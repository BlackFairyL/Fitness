package APIParse;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import APIParse.MusclePackage.Muscle;

public interface IMainView extends MvpView {
    void setExercise(List<Exercise> exercises);
    void setMuscle(List<Muscle> muscles);
    void load();
    void error();
}