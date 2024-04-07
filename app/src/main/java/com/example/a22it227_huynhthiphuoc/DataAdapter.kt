package com.example.a22it227_huynhthiphuoc
import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import com.example.a22it227_huynhthiphuoc.model.LopHoc

class DataAdapter(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "LopHocDatabase.db"
        private const val TABLE_NAME = "LopHoc"
        private const val COLUMN_MALOP = "malop"
        private const val COLUMN_TENLOP = "tenlop"
        private const val COLUMN_SISO = "siso"
        private const val COLUMN_KHOA = "khoa"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = ("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_MALOP TEXT PRIMARY KEY," +
                "$COLUMN_TENLOP TEXT," +
                "$COLUMN_SISO INTEGER," +
                "$COLUMN_KHOA TEXT)")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Thêm một lớp học vào cơ sở dữ liệu
    fun addLopHoc(lopHoc: LopHoc) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_MALOP, lopHoc.maLop)
        values.put(COLUMN_TENLOP, lopHoc.tenLop)
        values.put(COLUMN_SISO, lopHoc.siSo)
        values.put(COLUMN_KHOA, lopHoc.khoa)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    // Đọc tất cả các lớp học từ cơ sở dữ liệu
    @SuppressLint("Range")
    fun getAllLopHoc(): ArrayList<LopHoc> {
        val lopHocList = ArrayList<LopHoc>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val lopHoc = LopHoc(
                    cursor.getString(cursor.getColumnIndex(COLUMN_MALOP)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TENLOP)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_SISO)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_KHOA))
                )
                lopHocList.add(lopHoc)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lopHocList
    }

    // Xoá một lớp học từ cơ sở dữ liệu
    fun deleteLopHoc(maLop: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_MALOP = ?", arrayOf(maLop))
        db.close()
    }
}
