///////////////////////////////////////////////////////////////////////////////
//                                                                             
// JTOpen (IBM Toolbox for Java - OSS version)                              
//                                                                             
// Filename: SpooledFileListItem.java
//                                                                             
// The source code contained herein is licensed under the IBM Public License   
// Version 1.0, which has been approved by the Open Source Initiative.         
// Copyright (C) 1997-2003 International Business Machines Corporation and     
// others. All rights reserved.                                                
//                                                                             
///////////////////////////////////////////////////////////////////////////////

package com.ibm.as400.access.list;

import com.ibm.as400.access.*;
import java.util.*;

/**
 * Contains spooled file information that was generated by {@link com.ibm.as400.access.list.SpooledFileOpenList SpooledFileOpenList}.
 * <P>
 * Some attributes will not be available, depending on the {@link #getFormat format} that was used
 * to generate this item. The javadoc for each attribute getter indicates which formats will
 * generate valid data for the given attribute. If an attribute getter that is only valid for a format
 * other than what was used to generate this SpooledFileListItem, the data returned by that getter
 * is not valid.
**/
public class SpooledFileListItem
{
  private static final String copyright = "Copyright (C) 1997-2003 International Business Machines Corporation and others.";
  
  /**
   * Constant indicating the spooled file is assigned to a specific printer.
   * @see #getPrinterAssignment
  **/
  public static final String ASSIGNED_SPECIFIC = "1";

  /**
   * Constant indicating the spooled file is assigned to multiple printers.
   * @see #getPrinterAssignment
  **/
  public static final String ASSIGNED_MULTIPLE = "2";

  /**
   * Constant indicating the spooled file is not assigned to a printer.
   * @see #getPrinterAssignment
  **/
  public static final String ASSIGNED_NONE = "3";

  /**
   * Constant indicating the spooled file is intended for a diskette device.
   * @see #getDeviceType
  **/
  public static final String DEVICE_TYPE_DISKETTE = "DISKETTE";

  /**
   * Constant indicating the spooled file is intended for a printer device.
   * @see #getDeviceType
  **/
  public static final String DEVICE_TYPE_PRINTER = "PRINTER";

  /**
   * Constant indicating the spooled file is schedule immediate. A spooling writer
   * can process the spooled file immediately.
   * @see #getSchedule
  **/
  public static final String SCHEDULE_IMMEDIATE = "1";

  /**
   * Constant indicating the spooled file is schedule file end. A spooling writer
   * cannot process the spooled file until it has been closed.
   * @see #getSchedule
  **/
  public static final String SCHEDULE_FILE_END = "2";

  /**
   * Constant indicating the spooled file is schedule job end. A spooling writer
   * cannot process the spooled file until the job of the spooled file has ended.
   * @see #getSchedule
  **/
  public static final String SCHEDULE_JOB_END = "3";


  /**
   * Constant indicating the spooled file is available to be written to
   * an output device by a writer.
   * @see #getStatus
  **/
  public static final String STATUS_READY = "*READY";

  /**
   * Constant indicating the spooled file has not been processed completely
   * and is not ready to be selected by a writer.
   * @see #getStatus
  **/
  public static final String STATUS_OPEN = "*OPEN";

  /**
   * Constant indicating the spooled file has been processed completely by a
   * program, but SCHEDULE(*JOBEND) was specified. The job that produced the
   * spooled file has not finished.
   * @see #getStatus
  **/
  public static final String STATUS_CLOSED = "*CLOSED";

  /**
   * Constant indicating the spooled file has been written and then saved. This
   * spooled file remains saved until it is released.
   * @see #getStatus
  **/
  public static final String STATUS_SAVED = "*SAVED";

  /**
   * Constant indicating the spooled file currently is being produced by the writer
   * on an output device.
   * @see #getStatus
  **/
  public static final String STATUS_WRITING = "*WRITING";

  /**
   * Constant indicating the spooled file has been held.
   * @see #getStatus
  **/
  public static final String STATUS_HELD = "*HELD";

  /**
   * Constant indicating the spooled file has a message that needs a reply or needs
   * an action to be taken.
   * @see #getStatus
  **/
  public static final String STATUS_MESSAGE_WAIT = "*MESSAGE";

  /**
   * Constant indicating the spooled file is pending (waiting) to be printed.
   * @see #getStatus
  **/
  public static final String STATUS_PENDING = "*PENDING";

  /**
   * Constant indicating the spooled file has been sent to the printer completely,
   * but the print complete status has not been sent back.
   * @see #getStatus
  **/
  public static final String STATUS_PRINTING = "*PRINTING";

  /**
   * Constant indicating the spooled file is no longer in the system. A spooled file
   * with this status is only returned in the list of spooled files if the qualified
   * job name was specified.
   * @see #getStatus
  **/
  public static final String STATUS_FINISHED = "*FINISHED";

  /**
   * Constant indicating the spooled file is being sent or has been sent to a remote
   * system.
   * @see #getStatus
  **/
  public static final String STATUS_SENDING = "*SENDING";

  /**
   * Constant indicating the spooled file has been deferred from printing.
   * @see #getStatus
  **/
  public static final String STATUS_DEFERRED = "*DEFERRED";

  private String jobName_;
  private String jobUser_;
  private String jobNumber_;
  private String spooledFileName_;
  private int spooledFileNumber_;
  private String status_;
  private String dateOpened_;
  private String timeOpened_;
  private String spooledFileSchedule_;
  private String jobSystemName_;
  private String userData_;
  private String formType_;
  private String outputQueueName_;
  private String outputQueueLib_;
  private int asp_;
  private int size_;
  private int sizeMult_;
  private int totalPages_;
  private int copiesLeftToPrint_;
  private String priority_;

  private byte[] internalJobID_;
  private byte[] internalSplID_;
  private int currentPage_;
  private String deviceType_;
  private String printerAssigned_;
  private String printerName_;

  private String format_;

  SpooledFileListItem(String spooledFileName, String jobName, String jobUser, String jobNumber,
                      int spooledFileNumber, int totalPages, int currentPage, int copiesLeftToPrint,
                      String outputQueueName, String outputQueueLib, String userData, String status,
                      String formType, String priority, byte[] internalJobID, byte[] internalSplID,
                      String deviceType, String jobSystemName)
  {
    spooledFileName_ = spooledFileName;
    jobName_ = jobName_;
    jobUser_ = jobUser_;
    jobNumber_ = jobNumber;
    spooledFileNumber_ = spooledFileNumber;
    totalPages_ = totalPages_;
    currentPage_ = currentPage;
    copiesLeftToPrint_ = copiesLeftToPrint;
    outputQueueName_ = outputQueueName;
    outputQueueLib_ = outputQueueLib;
    userData_ = userData;
    status_ = status;
    formType_ = formType;
    priority_ = priority;
    internalJobID_ = internalJobID;
    internalSplID_ = internalSplID;
    deviceType_ = deviceType;
    jobSystemName_ = jobSystemName_;
    format_ = SpooledFileOpenList.FORMAT_0100;
  }

  SpooledFileListItem(String spooledFileName, String jobName, String jobUser, String jobNumber,
                      int spooledFileNumber, int totalPages, int currentPage, int copiesLeftToPrint,
                      String outputQueueName, String outputQueueLib, String userData, String status,
                      String formType, String priority, byte[] internalJobID, byte[] internalSplID,
                      String deviceType, String jobSystemName, String dateOpened, String timeOpened,
                      String printerAssigned, String printerName)
  {
    this(spooledFileName, jobName, jobUser, jobNumber, spooledFileNumber, totalPages, currentPage,
         copiesLeftToPrint, outputQueueName, outputQueueLib, userData, status, formType, priority,
         internalJobID, internalSplID, deviceType, jobSystemName);
    dateOpened_ = dateOpened;
    timeOpened_ = timeOpened;
    printerAssigned_ = printerAssigned;
    printerName_ = printerName;
    format_ = SpooledFileOpenList.FORMAT_0200;
  }

  SpooledFileListItem(String jobName, String jobUser, String jobNumber,
                      String spooledFileName, int spooledFileNumber, int status,
                      String dateOpened, String timeOpened, String spooledFileSchedule,
                      String jobSystemName, String userData, String formType,
                      String outputQueueName, String outputQueueLib, int asp, int size,
                      int sizeMult, int totalPages, int copiesLeftToPrint, String priority)
  {
    jobName_ = jobName;
    jobUser_ = jobUser;
    jobNumber_ = jobNumber;
    spooledFileName_ = spooledFileName;
    spooledFileNumber_ = spooledFileNumber;
    status_ = mapStatus(status);
    dateOpened_ = dateOpened;
    timeOpened_ = timeOpened;
    spooledFileSchedule_ = spooledFileSchedule;
    jobSystemName_ = jobSystemName;
    userData_ = userData;
    formType_ = formType;
    outputQueueName_ = outputQueueName;
    outputQueueLib_ = outputQueueLib;
    asp_ = asp;
    size_ = size;
    sizeMult_ = sizeMult;
    totalPages_ = totalPages;
    copiesLeftToPrint_ = copiesLeftToPrint;
    priority_ = priority;
    format_ = SpooledFileOpenList.FORMAT_0300;
  }

  /**
   * Returns the auxiliary storage pool (ASP) in which the spooled file resides.
   * Possible values are:
   * <UL>
   * <LI>1 - The system auxiliary storage pool (*SYSTEM).
   * <LI>2-32 - The number of the user auxiliary storage pool.
   * </UL>
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The auxiliary storage pool.
  **/
  public int getASP()
  {
    return asp_;
  }

  /**
   * Returns the remaining number of copies to be printed. This attribute applies
   * to printer device type spooled files only.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The number of copies left.
   * @see #getDeviceType
  **/
  public int getCopiesLeftToPrint()
  {
    return copiesLeftToPrint_;
  }

  /**
   * Returns the date and time the spooled file was created.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100} (V5R2 and higher),
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @see #getDateOpened
   * @see #getTimeOpened
   * @return The date and time formatted into a java.util.Date object.
  **/
  public Date getCreationDate()
  {
    Calendar c = Calendar.getInstance();
    c.clear();
    c.set(Integer.parseInt(dateOpened_.substring(0,3)) + 1900,// year
          Integer.parseInt(dateOpened_.substring(3,5))-1,     // month is zero based
          Integer.parseInt(dateOpened_.substring(5,7)),       // day
          Integer.parseInt(timeOpened_.substring(0,2)),       // hour
          Integer.parseInt(timeOpened_.substring(2,4)),      // minute
          Integer.parseInt(timeOpened_.substring(4,6)));    // second
    return c.getTime();
  }

  /**
   * Returns the page number or record number currently being written. The page number
   * may be lower or higher than the page number actually being printed because of
   * buffering done by the system. For example, if the spooled file is routed to a
   * diskette unit or the writer is currently printing job separators or file separators
   * for the spooled file, the page number returned may be zero.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200}
   * @return The current page number.
  **/
  public int getCurrentPage()
  {
    return currentPage_;
  }

  /**
   * Returns the date the spooled file was created.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100} (V5R2 and higher),
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @see #getCreationDate
   * @return The date in the format CYYMMDD.
  **/
  public String getDateOpened()
  {
    return dateOpened_;
  }
  
  /**
   * Returns the type of device for which the spooled file is intended.
   * Possible values are:
   * <UL>
   * <LI>{@link #DEVICE_TYPE_DISKETTE DEVICE_TYPE_DISKETTE}
   * <LI>{@link #DEVICE_TYPE_PRINTER DEVICE_TYPE_PRINTER}
   * </UL>
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200}
   * @return The device type.
  **/
  public String getDeviceType()
  {
    if (deviceType_.equals(DEVICE_TYPE_PRINTER)) return DEVICE_TYPE_PRINTER;
    if (deviceType_.equals(DEVICE_TYPE_DISKETTE)) return DEVICE_TYPE_DISKETTE;
    return deviceType_;
  }

  /**
   * Returns the format that was used by SpooledFileOpenList to generate this item.
   * @return The format.
   * @see com.ibm.as400.access.list.SpooledFileListItem#getFormat
  **/
  public String getFormat()
  {
    return format_;
  }

  /**
   * Returns the type of forms that should be loaded on the printer before this
   * spooled file is printed.  This attribute applies to printer device type spooled
   * files only.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The form type.
   * @see #getDeviceType
  **/
  public String getFormType()
  {
    return formType_;
  }

  /**
   * Returns the internal job identifier for the job that created the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200}
   * @return The 16-byte internal job ID.
   * @see com.ibm.as400.access.Job#setInternalJobIdentifier
  **/
  public byte[] getInternalJobIdentifier()
  {
    return internalJobID_;
  }

  /**
   * Returns the internal spooled file identifier for the spooled file.
   * This is the input value that other programs use to improve the
   * performance of locating the spooled file on the system. Only the spooled
   * file APIs use this identifier, not any other interface on the system.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200}
   * @return The 16-byte internal spooled file ID.
  **/
  public byte[] getInternalSpooledFileIdentifier()
  {
    return internalJobID_;
  }

  /**
   * Returns the name of the job that created the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The job name.
   * @see #getJobNumber
   * @see #getJobUser
  **/
  public String getJobName()
  {
    return jobName_;
  }

  /**
   * Returns the number of the job that created the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The job number.
   * @see #getJobName
   * @see #getJobUser
  **/
  public String getJobNumber()
  {
    return jobNumber_;
  }

  /**
   * Returns the system name of the job that created the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100} (V5R2 and higher),
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The system name.
  **/
  public String getJobSystemName()
  {
    return jobSystemName_;
  }

  /**
   * Returns the user of the job that created the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The user name.
   * @see #getJobName
   * @see #getJobNumber
  **/
  public String getJobUser()
  {
    return jobUser_;
  }

  /**
   * Returns the name of the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The spooled file name.
  **/
  public String getName()
  {
    return spooledFileName_;
  }
  
  /**
   * Returns the number of the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The spooled file number.
  **/
  public int getNumber()
  {
    return spooledFileNumber_;
  }

  /**
   * Returns the fully-qualified integrated file system path of the output queue in 
   * which the spooled file is located.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The output queue.
   * @see #getOutputQueueName
   * @see #getOutputQueueLibrary
  **/
  public String getOutputQueue()
  {
    return QSYSObjectPathName.toPath(outputQueueLib_, outputQueueName_, "OUTQ");
  }

  /**
   * Returns the library of the output queue in which the spooled file is located.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The library.
   * @see #getOutputQueue
  **/
  public String getOutputQueueLibrary()
  {
    return outputQueueLib_;
  }

  /**
   * Returns the name of the output queue in which the spooled file is located.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The output queue name.
   * @see #getOutputQueue
  **/
  public String getOutputQueueName()
  {
    return outputQueueName_;
  }

  /**
   * Returns how the spooled file is assigned. This attribute applies to printer device
   * type spooled files only. Possible values are:
   * <UL>
   * <LI>{@link #ASSIGNED_SPECIFIC ASSIGNED_SPECIFIC} - The printer name will be valid.
   * <LI>{@link #ASSIGNED_MULTIPLE ASSIGNED_MULTIPLE} - The printer name will be blank.
   * <LI>{@link #ASSIGNED_NONE ASSIGNED_NONE} - The printer name will be blank.
   * </UL>
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200}
   * @return The printer assignment.
   * @see #getPrinterName
   * @see #getDeviceType
  **/
  public String getPrinterAssignment()
  {
    if (printerAssigned_.equals(ASSIGNED_SPECIFIC)) return ASSIGNED_SPECIFIC;
    if (printerAssigned_.equals(ASSIGNED_MULTIPLE)) return ASSIGNED_MULTIPLE;
    if (printerAssigned_.equals(ASSIGNED_NONE)) return ASSIGNED_NONE;
    return printerAssigned_;
  }

  /**
   * Returns the name of the printer the spooled file has been assigned to print on.
   * This attribute applies to printer device type spooled files only, and is only
   * valid when the printer assignment is ASSIGNED_SPECIFIC.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200}
   * @return The printer name.
   * @see #getPrinterAssignment
   * @see #getDeviceType
  **/
  public String getPrinterName()
  {
    return printerName_;
  }

  /**
   * Returns the priority of the spooled file. The priority ranges from 1 (highest)
   * to 9 (lowest).
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The priority.
  **/
  public String getPriority()
  {
    return priority_;
  }
  
  /**
   * Returns the schedule of the spooled file.
   * Possible values are:
   * <UL>
   * <LI>{@link #SCHEDULE_IMMEDIATE SCHEDULE_IMMEDIATE}
   * <LI>{@link #SCHEDULE_FILE_END SCHEDULE_FILE_END}
   * <LI>{@link #SCHEDULE_JOB_END SCHEDULE_JOB_END}
   * </UL>
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The schedule.
  **/
  public String getSchedule()
  {
    if (spooledFileSchedule_.equals(SCHEDULE_IMMEDIATE)) return SCHEDULE_IMMEDIATE;
    if (spooledFileSchedule_.equals(SCHEDULE_FILE_END)) return SCHEDULE_FILE_END;
    if (spooledFileSchedule_.equals(SCHEDULE_JOB_END)) return SCHEDULE_JOB_END;
    return spooledFileSchedule_;
  }

  /**
   * Returns the spooled file size in bytes. The size of the spooled file
   * is the data stream size, plus the spooled file's attributes, plus the
   * overhead storage used to store the spooled file's data stream.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The size.
  **/
  public long getSize()
  {
    if (sizeMult_ > 0) return (long)size_*(long)sizeMult_;
    return size_;
  }

  /**
   * Returns the status of the spooled file.
   * Possible values are:
   * <UL>
   * <LI>{@link #STATUS_READY STATUS_READY}
   * <LI>{@link #STATUS_OPEN STATUS_OPEN}
   * <LI>{@link #STATUS_CLOSED STATUS_CLOSED}
   * <LI>{@link #STATUS_SAVED STATUS_SAVED}
   * <LI>{@link #STATUS_WRITING STATUS_WRITING}
   * <LI>{@link #STATUS_HELD STATUS_HELD}
   * <LI>{@link #STATUS_MESSAGE_WAIT STATUS_MESSAGE_WAIT}
   * <LI>{@link #STATUS_PENDING STATUS_PENDING}
   * <LI>{@link #STATUS_PRINTING STATUS_PRINTING}
   * <LI>{@link #STATUS_FINISHED STATUS_FINISHED}
   * <LI>{@link #STATUS_SENDING STATUS_SENDING}
   * <LI>{@link #STATUS_DEFERRED STATUS_DEFERRED}
   * </UL>
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The status.
  **/
  public String getStatus()
  {
    if (status_.equals(STATUS_READY)) return STATUS_READY;
    if (status_.equals(STATUS_OPEN)) return STATUS_OPEN;
    if (status_.equals(STATUS_CLOSED)) return STATUS_CLOSED;
    if (status_.equals(STATUS_SAVED)) return STATUS_SAVED;
    if (status_.equals(STATUS_WRITING)) return STATUS_WRITING;
    if (status_.equals(STATUS_HELD)) return STATUS_HELD;
    if (status_.equals(STATUS_MESSAGE_WAIT)) return STATUS_MESSAGE_WAIT;
    if (status_.equals(STATUS_PENDING)) return STATUS_PENDING;
    if (status_.equals(STATUS_PRINTING)) return STATUS_PRINTING;
    if (status_.equals(STATUS_FINISHED)) return STATUS_FINISHED;
    if (status_.equals(STATUS_SENDING)) return STATUS_SENDING;
    if (status_.equals(STATUS_DEFERRED)) return STATUS_DEFERRED;

    return status_;
  }

  /**
   * Returns the time the spooled file was created.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100} (V5R2 and higher),
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @see #getCreationDate
   * @return The time in the format HHMMSS.
  **/
  public String getTimeOpened()
  {
    return timeOpened_;
  }

  /**
   * Returns the total number of pages or number of records for this spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The number of pages.
  **/
  public int getTotalPages()
  {
    return totalPages_;
  }

  /**
   * Returns the 10 characters of user-specified data that describe the spooled file.
   * <P>Available in format: {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0100 FORMAT_0100},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0200 FORMAT_0200},
   *                         {@link com.ibm.as400.access.list.SpooledFileOpenList#FORMAT_0300 FORMAT_0300}
   * @return The user data.
  **/
  public String getUserData()
  {
    return userData_;
  }


  // Helper method used to convert the integer status returned by one API format
  // to the String status returned by the other API format.
  private static final String mapStatus(int status)
  {
    switch(status)
    {
      case 1:
        return STATUS_READY;
      case 2:
        return STATUS_OPEN;
      case 3:
        return STATUS_CLOSED;
      case 4:
        return STATUS_SAVED;
      case 5:
        return STATUS_WRITING;
      case 6:
        return STATUS_HELD;
      case 7:
        return STATUS_MESSAGE_WAIT;
      case 8:
        return STATUS_PENDING;
      case 9:
        return STATUS_PRINTING;
      case 10:
        return STATUS_FINISHED;
      case 11:
        return STATUS_SENDING;
      case 12:
        return STATUS_DEFERRED;
      default:
        return ""; // Shouldn't happen.
    }
  }

}

