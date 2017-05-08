package com.betelgeuse.dao.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.betelgeuse.dao.app.converter.NoteTypeConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

@Entity
public class Note implements Parcelable {

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
    @Id
    private Long id ;
    @NotNull
    private String title;
    private String story;
    private java.util.Date date = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime();
    @Convert(converter = NoteTypeConverter.class, columnType = String.class)
    private NoteType type;

    @Generated(hash = 1272611929)
    public Note() {
    }

    public Note(Long id) {

        this.id = id;
    }

    @Generated(hash = 1602991252)
    public Note(Long id, @NotNull String title, String story, java.util.Date date,
                NoteType type) {
        this.id = id;
        this.title = title;
        this.story = story;
        this.date = date;
        this.type = type;
    }

    protected Note(Parcel in) {
        title = in.readString();
        story = in.readString();
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", story='" + story + '\'' +
                ", date=" + date +
                ", type=" + type +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(story);
    }
}
