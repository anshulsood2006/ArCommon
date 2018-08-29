package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;
import com.arsoft.projects.common.exception.ArException;

public interface ArScripDataFileWriter_IF {
	public void writeData(ArScripDataFile arScripDataFile) throws ArException;
	public void updateData(ArScripDataFile arScripDataFileCached, ArScripDataFile arScripDataFileNew) throws ArException;
}
