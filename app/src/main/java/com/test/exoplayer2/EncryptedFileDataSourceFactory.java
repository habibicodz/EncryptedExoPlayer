package com.deepforensic.gallerylock.business.repositories;

import com.google.android.exoplayer2.upstream.DataSource;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * Created by michaeldunn on 3/13/17.
 */

public class EncryptedFileDataSourceFactory implements DataSource.Factory {

  private final Cipher mCipher;
  private final SecretKey mSecretKeySpec;
  private final IvParameterSpec mIvParameterSpec;

  public EncryptedFileDataSourceFactory(Cipher cipher, SecretKey secretKeySpec, IvParameterSpec ivParameterSpec) {
    mCipher = cipher;
    mSecretKeySpec = secretKeySpec;
    mIvParameterSpec = ivParameterSpec;
  }

  @Override
  public EncryptedFileDataSource createDataSource() {
    return new EncryptedFileDataSource(mCipher, mSecretKeySpec, mIvParameterSpec);
  }

}