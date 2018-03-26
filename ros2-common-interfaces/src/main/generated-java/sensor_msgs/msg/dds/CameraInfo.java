package sensor_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message defines meta information for a camera. It should be in a
 * camera namespace on topic "camera_info" and accompanied by up to five
 * image topics named:
 *
 * image_raw - raw data from the camera driver, possibly Bayer encoded
 * image            - monochrome, distorted
 * image_color      - color, distorted
 * image_rect       - monochrome, rectified
 * image_rect_color - color, rectified
 *
 * The image_pipeline contains packages (image_proc, stereo_image_proc)
 * for producing the four processed image topics from image_raw and
 * camera_info. The meaning of the camera parameters are described in
 * detail at http://www.ros.org/wiki/image_pipeline/CameraInfo.
 *
 * The image_geometry package provides a user-friendly interface to
 * common operations using this meta information. If you want to, e.g.,
 * project a 3d point into image coordinates, we strongly recommend
 * using image_geometry.
 *
 * If the camera is uncalibrated, the matrices D, K, R, P should be left
 * zeroed out. In particular, clients may assume that K[0] == 0.0
 * indicates an uncalibrated camera.
 * ######################################################################
 * Image acquisition info                          #
 * ######################################################################
 * Header frame_id should be optical frame of camera
 * origin of frame should be optical center of camera
 * +x should point to the right in the image
 * +y should point down in the image
 * +z should point into the plane of the image
 * ######################################################################
 * Calibration Parameters                         #
 * ######################################################################
 * These are fixed during camera calibration. Their values will be the #
 * same in all messages until the camera is recalibrated. Note that    #
 * self-calibrating systems may "recalibrate" frequently.              #
 * #
 * The internal parameters can be used to warp a raw (distorted) image #
 * to:                                                                 #
 * 1. An undistorted image (requires D and K)                        #
 * 2. A rectified image (requires D, K, R)                           #
 * The projection matrix P projects 3D points into the rectified image.#
 * ######################################################################
 * ######################################################################
 * Operational Parameters                         #
 * ######################################################################
 * These define the image region actually captured by the camera       #
 * driver. Although they affect the geometry of the output image, they #
 * may be changed freely without recalibrating the camera.             #
 * ######################################################################
 */
public class CameraInfo implements Settable<CameraInfo>, EpsilonComparable<CameraInfo>
{
   /**
    * Time of image acquisition, camera coordinate frame ID
    * Header timestamp should be acquisition time of image
    */
   private std_msgs.msg.dds.Header header_;
   /**
    * The image dimensions with which the camera was calibrated.
    * Normally this will be the full camera resolution in pixels.
    */
   private long height_;
   private long width_;
   /**
    * The distortion model used. Supported models are listed in
    * sensor_msgs/distortion_models.h. For most cameras, "plumb_bob" - a
    * simple model of radial and tangential distortion - is sufficent.
    */
   private java.lang.StringBuilder distortion_model_;
   /**
    * The distortion parameters, size depending on the distortion model.
    * For "plumb_bob", the 5 parameters are: (k1, k2, t1, t2, k3).
    */
   private us.ihmc.idl.IDLSequence.Double d_;
   /**
    * Intrinsic camera matrix for the raw (distorted) images.
    * [fx  0 cx]
    * K = [ 0 fy cy]
    * [ 0  0  1]
    * Projects 3D points in the camera coordinate frame to 2D pixel
    * coordinates using the focal lengths (fx, fy) and principal point
    * (cx, cy).
    * 3x3 row-major matrix
    */
   private double[] k_;
   /**
    * Rectification matrix (stereo cameras only)
    * A rotation matrix aligning the camera coordinate system to the ideal
    * stereo image plane so that epipolar lines in both stereo images are
    * parallel.
    * 3x3 row-major matrix
    */
   private double[] r_;
   /**
    * Projection/camera matrix
    * [fx'  0  cx' Tx]
    * P = [ 0  fy' cy' Ty]
    * [ 0   0   1   0]
    * By convention, this matrix specifies the intrinsic (camera) matrix
    * of the processed (rectified) image. That is, the left 3x3 portion
    * is the normal camera intrinsic matrix for the rectified image.
    * It projects 3D points in the camera coordinate frame to 2D pixel
    * coordinates using the focal lengths (fx', fy') and principal point
    * (cx', cy') - these may differ from the values in K.
    * For monocular cameras, Tx = Ty = 0. Normally, monocular cameras will
    * also have R = the identity and P[1:3,1:3] = K.
    * For a stereo pair, the fourth column [Tx Ty 0]' is related to the
    * position of the optical center of the second camera in the first
    * camera's frame. We assume Tz = 0 so both cameras are in the same
    * stereo image plane. The first camera always has Tx = Ty = 0. For
    * the right (second) camera of a horizontal stereo pair, Ty = 0 and
    * Tx = -fx' * B, where B is the baseline between the cameras.
    * Given a 3D point [X Y Z]', the projection (x, y) of the point onto
    * the rectified image is given by:
    * [u v w]' = P * [X Y Z 1]'
    * x = u / w
    * y = v / w
    * This holds for both images of a stereo pair.
    * 3x4 row-major matrix
    */
   private double[] p_;
   /**
    * Binning refers here to any camera setting which combines rectangular
    * neighborhoods of pixels into larger "super-pixels." It reduces the
    * resolution of the output image to
    * (width / binning_x) x (height / binning_y).
    * The default values binning_x = binning_y = 0 is considered the same
    * as binning_x = binning_y = 1 (no subsampling).
    */
   private long binning_x_;
   private long binning_y_;
   /**
    * Region of interest (subwindow of full camera resolution), given in
    * full resolution (unbinned) image coordinates. A particular ROI
    * always denotes the same window of pixels on the camera sensor,
    * regardless of binning settings.
    * The default setting of roi (all values 0) is considered the same as
    * full resolution (roi.width = width, roi.height = height).
    */
   private sensor_msgs.msg.dds.RegionOfInterest roi_;

   public CameraInfo()
   {
      header_ = new std_msgs.msg.dds.Header();

      distortion_model_ = new java.lang.StringBuilder(255);

      d_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      k_ = new double[9];

      r_ = new double[9];

      p_ = new double[12];

      roi_ = new sensor_msgs.msg.dds.RegionOfInterest();
   }

   public CameraInfo(CameraInfo other)
   {
      set(other);
   }

   public void set(CameraInfo other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      height_ = other.height_;

      width_ = other.width_;

      distortion_model_.setLength(0);
      distortion_model_.append(other.distortion_model_);

      d_.set(other.d_);
      for (int i1 = 0; i1 < k_.length; ++i1)
      {
         k_[i1] = other.k_[i1];
      }

      for (int i3 = 0; i3 < r_.length; ++i3)
      {
         r_[i3] = other.r_[i3];
      }

      for (int i5 = 0; i5 < p_.length; ++i5)
      {
         p_[i5] = other.p_[i5];
      }

      binning_x_ = other.binning_x_;

      binning_y_ = other.binning_y_;

      sensor_msgs.msg.dds.RegionOfInterestPubSubType.staticCopy(other.roi_, roi_);
   }

   /**
    * Time of image acquisition, camera coordinate frame ID
    * Header timestamp should be acquisition time of image
    */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
    * The image dimensions with which the camera was calibrated.
    * Normally this will be the full camera resolution in pixels.
    */
   public long getHeight()
   {
      return height_;
   }

   /**
    * The image dimensions with which the camera was calibrated.
    * Normally this will be the full camera resolution in pixels.
    */
   public void setHeight(long height)
   {
      height_ = height;
   }

   public long getWidth()
   {
      return width_;
   }

   public void setWidth(long width)
   {
      width_ = width;
   }

   /**
    * The distortion model used. Supported models are listed in
    * sensor_msgs/distortion_models.h. For most cameras, "plumb_bob" - a
    * simple model of radial and tangential distortion - is sufficent.
    */
   public java.lang.String getDistortionModelAsString()
   {
      return getDistortionModel().toString();
   }

   /**
    * The distortion model used. Supported models are listed in
    * sensor_msgs/distortion_models.h. For most cameras, "plumb_bob" - a
    * simple model of radial and tangential distortion - is sufficent.
    */
   public java.lang.StringBuilder getDistortionModel()
   {
      return distortion_model_;
   }

   /**
    * The distortion model used. Supported models are listed in
    * sensor_msgs/distortion_models.h. For most cameras, "plumb_bob" - a
    * simple model of radial and tangential distortion - is sufficent.
    */
   public void setDistortionModel(java.lang.String distortion_model)
   {
      distortion_model_.setLength(0);
      distortion_model_.append(distortion_model);
   }

   /**
    * The distortion parameters, size depending on the distortion model.
    * For "plumb_bob", the 5 parameters are: (k1, k2, t1, t2, k3).
    */
   public us.ihmc.idl.IDLSequence.Double getD()
   {
      return d_;
   }

   /**
    * Intrinsic camera matrix for the raw (distorted) images.
    * [fx  0 cx]
    * K = [ 0 fy cy]
    * [ 0  0  1]
    * Projects 3D points in the camera coordinate frame to 2D pixel
    * coordinates using the focal lengths (fx, fy) and principal point
    * (cx, cy).
    * 3x3 row-major matrix
    */
   public double[] getK()
   {
      return k_;
   }

   /**
    * Rectification matrix (stereo cameras only)
    * A rotation matrix aligning the camera coordinate system to the ideal
    * stereo image plane so that epipolar lines in both stereo images are
    * parallel.
    * 3x3 row-major matrix
    */
   public double[] getR()
   {
      return r_;
   }

   /**
    * Projection/camera matrix
    * [fx'  0  cx' Tx]
    * P = [ 0  fy' cy' Ty]
    * [ 0   0   1   0]
    * By convention, this matrix specifies the intrinsic (camera) matrix
    * of the processed (rectified) image. That is, the left 3x3 portion
    * is the normal camera intrinsic matrix for the rectified image.
    * It projects 3D points in the camera coordinate frame to 2D pixel
    * coordinates using the focal lengths (fx', fy') and principal point
    * (cx', cy') - these may differ from the values in K.
    * For monocular cameras, Tx = Ty = 0. Normally, monocular cameras will
    * also have R = the identity and P[1:3,1:3] = K.
    * For a stereo pair, the fourth column [Tx Ty 0]' is related to the
    * position of the optical center of the second camera in the first
    * camera's frame. We assume Tz = 0 so both cameras are in the same
    * stereo image plane. The first camera always has Tx = Ty = 0. For
    * the right (second) camera of a horizontal stereo pair, Ty = 0 and
    * Tx = -fx' * B, where B is the baseline between the cameras.
    * Given a 3D point [X Y Z]', the projection (x, y) of the point onto
    * the rectified image is given by:
    * [u v w]' = P * [X Y Z 1]'
    * x = u / w
    * y = v / w
    * This holds for both images of a stereo pair.
    * 3x4 row-major matrix
    */
   public double[] getP()
   {
      return p_;
   }

   /**
    * Binning refers here to any camera setting which combines rectangular
    * neighborhoods of pixels into larger "super-pixels." It reduces the
    * resolution of the output image to
    * (width / binning_x) x (height / binning_y).
    * The default values binning_x = binning_y = 0 is considered the same
    * as binning_x = binning_y = 1 (no subsampling).
    */
   public long getBinningX()
   {
      return binning_x_;
   }

   /**
    * Binning refers here to any camera setting which combines rectangular
    * neighborhoods of pixels into larger "super-pixels." It reduces the
    * resolution of the output image to
    * (width / binning_x) x (height / binning_y).
    * The default values binning_x = binning_y = 0 is considered the same
    * as binning_x = binning_y = 1 (no subsampling).
    */
   public void setBinningX(long binning_x)
   {
      binning_x_ = binning_x;
   }

   public long getBinningY()
   {
      return binning_y_;
   }

   public void setBinningY(long binning_y)
   {
      binning_y_ = binning_y;
   }

   /**
    * Region of interest (subwindow of full camera resolution), given in
    * full resolution (unbinned) image coordinates. A particular ROI
    * always denotes the same window of pixels on the camera sensor,
    * regardless of binning settings.
    * The default setting of roi (all values 0) is considered the same as
    * full resolution (roi.width = width, roi.height = height).
    */
   public sensor_msgs.msg.dds.RegionOfInterest getRoi()
   {
      return roi_;
   }

   @Override
   public boolean epsilonEquals(CameraInfo other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_, other.height_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.width_, other.width_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.distortion_model_, other.distortion_model_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.d_, other.d_, epsilon))
         return false;

      for (int i7 = 0; i7 < k_.length; ++i7)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.k_[i7], other.k_[i7], epsilon))
            return false;
      }

      for (int i9 = 0; i9 < r_.length; ++i9)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.r_[i9], other.r_[i9], epsilon))
            return false;
      }

      for (int i11 = 0; i11 < p_.length; ++i11)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.p_[i11], other.p_[i11], epsilon))
            return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.binning_x_, other.binning_x_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.binning_y_, other.binning_y_, epsilon))
         return false;

      if (!this.roi_.epsilonEquals(other.roi_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof CameraInfo))
         return false;

      CameraInfo otherMyClass = (CameraInfo) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (this.height_ != otherMyClass.height_)
         return false;

      if (this.width_ != otherMyClass.width_)
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.distortion_model_, otherMyClass.distortion_model_))
         return false;

      if (!this.d_.equals(otherMyClass.d_))
         return false;

      for (int i13 = 0; i13 < k_.length; ++i13)
      {
         if (this.k_[i13] != otherMyClass.k_[i13])
            return false;
      }
      for (int i15 = 0; i15 < r_.length; ++i15)
      {
         if (this.r_[i15] != otherMyClass.r_[i15])
            return false;
      }
      for (int i17 = 0; i17 < p_.length; ++i17)
      {
         if (this.p_[i17] != otherMyClass.p_[i17])
            return false;
      }
      if (this.binning_x_ != otherMyClass.binning_x_)
         return false;

      if (this.binning_y_ != otherMyClass.binning_y_)
         return false;

      if (!this.roi_.equals(otherMyClass.roi_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("CameraInfo {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);

      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);

      builder.append(", ");
      builder.append("distortion_model=");
      builder.append(this.distortion_model_);

      builder.append(", ");
      builder.append("d=");
      builder.append(this.d_);

      builder.append(", ");
      builder.append("k=");
      builder.append(java.util.Arrays.toString(this.k_));

      builder.append(", ");
      builder.append("r=");
      builder.append(java.util.Arrays.toString(this.r_));

      builder.append(", ");
      builder.append("p=");
      builder.append(java.util.Arrays.toString(this.p_));

      builder.append(", ");
      builder.append("binning_x=");
      builder.append(this.binning_x_);

      builder.append(", ");
      builder.append("binning_y=");
      builder.append(this.binning_y_);

      builder.append(", ");
      builder.append("roi=");
      builder.append(this.roi_);

      builder.append("}");
      return builder.toString();
   }
}
