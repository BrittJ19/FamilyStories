package com.techelevator.dao;

import com.techelevator.model.ReadingLogList;
import com.techelevator.model.ReadingRecord;

import java.util.List;

public interface RecordDao {

    public boolean createRecord(ReadingRecord readingRecord, int userId);

     int getTotalPagesRead(int userId);

    int getTotalReadingTime(int userId);

    int getTotalBooksCompleted(int userId);

    int getTotalMoneyEarned(int userId);

    int getTotalMoneyDonated(int userId);

    List<ReadingLogList> getReadingActivity(int userId);
}
