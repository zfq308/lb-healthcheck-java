/**
 * Copyright (c) 2015 Hosting.com, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.hosting.lb.healthcheck;

public class SimpleHealthCheckResult extends BasicHealthCheckResult
{
	public static final SimpleHealthCheckResult	SUCCESS	= new SimpleHealthCheckResult (false, 200, "OK");
	public static final SimpleHealthCheckResult	FAIL	= new SimpleHealthCheckResult (true, 500,
																"Unspecified error");

	public SimpleHealthCheckResult (boolean error, int code, String message)
	{
		super (error, code, message);
	}

	public static SimpleHealthCheckResult fail (String message)
	{
		SimpleHealthCheckResult result = FAIL;
		result.setMessage (message);
		return result;
	}

	public static SimpleHealthCheckResult success (String message)
	{
		SimpleHealthCheckResult result = SUCCESS;
		result.setMessage (message);
		return result;
	}
}
