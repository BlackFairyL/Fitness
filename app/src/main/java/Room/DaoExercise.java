package Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import APIParse.Exercise;

@Dao
public interface DaoExercise {

    @Query("SELECT * FROM exercise")
    List<Exercise> getAllExercise();

    @Insert
    void insertExercise(Exercise exercise);

    @Delete
    void delete(Exercise exercise);
}