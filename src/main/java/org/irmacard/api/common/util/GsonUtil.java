/*
 * GsonUtil.java
 *
 * Copyright (c) 2015, Sietse Ringers, Radboud University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the IRMA project nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.irmacard.api.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.irmacard.api.common.AttributeDisjunction;
import org.irmacard.credentials.idemix.proofs.Proof;
import org.irmacard.credentials.info.AttributeIdentifier;
import org.irmacard.credentials.info.CredentialIdentifier;
import org.irmacard.credentials.info.ObjectIdentifier;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Keeps a {@link Gson} instance to which type adapters can be added
 * via {@link #addTypeAdapter(Class, Object)}.
 */
public class GsonUtil {
	protected static GsonUtilBuilder builder = new GsonUtilBuilder();
	protected static Gson gson = builder.create();

	/**
	 * Add the specified type adapter for the specified class.
	 */
	public static void addTypeAdapter(Class clazz, Object o) {
		builder.addTypeAdapter(clazz, 0);
	}

	public static Gson getGson() {
		if (builder.shouldReload())
			gson = builder.create();
		return gson;
	}
}
