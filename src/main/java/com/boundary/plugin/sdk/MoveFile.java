// Copyright 2014-2015 Boundary, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.boundary.plugin.sdk;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;

public class MoveFile implements PostExtract{
	
	private static Logger LOG = LoggerFactory.getLogger(MoveFile.class);
	
	MoveFile()  {
		
	}
	
	@Override
	public int execute(String[] args) {
		System.out.println(args.length);
		int result = 1;
		try {
			if (args.length != 2) {
				throw new Exception("Missing either source or destination paths");
			}
			File from = new File(args[0]);
			File to = new File(args[1]);
			Files.copy(from,to);
			result = 0;
		} catch (Exception e) {
			LOG.error("%s%n",e.getMessage());
		}
		return result;
	}
	
	public static void main(String [] args) {
		MoveFile mv = new MoveFile();
		mv.execute(args);
	}
}
