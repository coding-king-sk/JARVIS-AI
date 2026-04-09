package com.jarvis.ai.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jarvis.ai.database.entity.GeneratedMedia;

import java.util.List;

@Dao
public interface GeneratedMediaDao {

    @Insert
    void insertMedia(GeneratedMedia media);

    @Update
    void updateMedia(GeneratedMedia media);

    @Delete
    void deleteMedia(GeneratedMedia media);

    @Query("SELECT * FROM generated_media ORDER BY timestamp DESC")
    List<GeneratedMedia> getAllMedia();

    @Query("SELECT * FROM generated_media WHERE media_type = :type ORDER BY timestamp DESC")
    List<GeneratedMedia> getMediaByType(String type);

    @Query("SELECT * FROM generated_media WHERE quality = :quality ORDER BY timestamp DESC")
    List<GeneratedMedia> getMediaByQuality(String quality);

    @Query("SELECT * FROM generated_media ORDER BY timestamp DESC LIMIT :limit")
    List<GeneratedMedia> getRecentMedia(int limit);

    @Query("DELETE FROM generated_media")
    void deleteAllMedia();

    @Query("SELECT COUNT(*) FROM generated_media WHERE media_type = :type")
    int getMediaCount(String type);
}