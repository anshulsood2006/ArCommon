package com.arsoft.projects.common.business.market.interfaces;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.business.market.entities.datafile.ArScripDataFile;

public interface ArScripDataFileWriter_IF {
	public void writeData(ArScripDataFile arScripDataFile) throws ArException;
	public void updateData(ArScripDataFile arScripDataFileCached, ArScripDataFile arScripDataFileNew) throws ArException;
}
