package com.scwen7.baseproject.common.http.download;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * User: Season(ssseasonnn@gmail.com)
 * Date: 2016-07-15
 * Time: 15:48
 * 表示下载状态, 如果isChunked为true, totalSize 可能不存在
 */
public class DownloadStatus implements Parcelable {
    public static final Creator<DownloadStatus> CREATOR
            = new Creator<DownloadStatus>() {
        @Override
        public DownloadStatus createFromParcel(Parcel source) {
            return new DownloadStatus(source);
        }

        @Override
        public DownloadStatus[] newArray(int size) {
            return new DownloadStatus[size];
        }
    };


    private long totalSize;
    private long downloadSize;

    public DownloadStatus() {
    }

    public DownloadStatus(long downloadSize, long totalSize) {
        this.downloadSize = downloadSize;
        this.totalSize = totalSize;
    }

    public DownloadStatus(boolean isChunked, long downloadSize, long totalSize) {

        this.downloadSize = downloadSize;
        this.totalSize = totalSize;
    }

    protected DownloadStatus(Parcel in) {

        this.totalSize = in.readLong();
        this.downloadSize = in.readLong();
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(long downloadSize) {
        this.downloadSize = downloadSize;
    }

    /**
     * 获得格式化的总Size
     *
     * @return example: 2KB , 10MB
     */
    public String getFormatTotalSize() {
        return formatSize(totalSize);
    }

    public String getFormatDownloadSize() {
        return formatSize(downloadSize);
    }

    public static String formatSize(long size) {
        String hrSize;
        double b = size;
        double k = size / 1024.0;
        double m = ((size / 1024.0) / 1024.0);
        double g = (((size / 1024.0) / 1024.0) / 1024.0);
        double t = ((((size / 1024.0) / 1024.0) / 1024.0) / 1024.0);
        DecimalFormat dec = new DecimalFormat("0.00");
        if (t > 1) {
            hrSize = dec.format(t).concat(" TB");
        } else if (g > 1) {
            hrSize = dec.format(g).concat(" GB");
        } else if (m > 1) {
            hrSize = dec.format(m).concat(" MB");
        } else if (k > 1) {
            hrSize = dec.format(k).concat(" KB");
        } else {
            hrSize = dec.format(b).concat(" B");
        }
        return hrSize;
    }


    /**
     * 获得格式化的状态字符串
     *
     * @return example: 2MB/36MB
     */
    public String getFormatStatusString() {
        return getFormatDownloadSize() + "/" + getFormatTotalSize();
    }

    /**
     * 获得下载的百分比, 保留两位小数
     *
     * @return example: 5.25%
     */
    public String getPercent() {
        String percent;
        Double result;
        if (totalSize == 0L) {
            result = 0.0;
        } else {
            result = downloadSize * 1.0 / totalSize;
        }
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);//控制保留小数点后几位，2：表示保留2位小数点
        percent = nf.format(result);
        return percent;
    }

    /**
     * 获得下载的百分比数值
     *
     * @return example: 5%  will return 5, 10% will return 10.
     */
    public long getPercentNumber() {
        double result;
        if (totalSize == 0L) {
            result = 0.0;
        } else {
            result = downloadSize * 1.0 / totalSize;
        }
        return (long) (result * 100);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.totalSize);
        dest.writeLong(this.downloadSize);
    }
}
