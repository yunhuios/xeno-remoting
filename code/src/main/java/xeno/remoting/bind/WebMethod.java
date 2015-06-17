/**
 * NOTICE - T20150126
 * 
 * The "xeno-remoting" is free software, licensed under the Apache License, Version 2.0 (the "License").
 * Commercial and non-commercial use are permitted in compliance with the License.
 * 
 * Copyright (c) 2015 Kai Feng, All rights reserved.
 * 
 * You may obtain a copy of the License at: "http://www.apache.org/licenses/LICENSE-2.0".
 * In addition, a copy of the License is included with this distribution.
 * 
 * As stated in Section 7, "Disclaimer of Warranty" of the License:
 * 
 * 7. Disclaimer of Warranty. Unless required by applicable law or
 *    agreed to in writing, Licensor provides the Work (and each
 *    Contributor provides its Contributions) on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *    implied, including, without limitation, any warranties or conditions
 *    of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A
 *    PARTICULAR PURPOSE. You are solely responsible for determining the
 *    appropriateness of using or redistributing the Work and assume any
 *    risks associated with Your exercise of permissions under this License.
 * 
 * The source code is available at: "https://github.com/kfeng2015/xeno-remoting".
 */
package xeno.remoting.bind;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * An annotation uses to mark a method as a web method, it should meet below
 * requirements:
 * </p>
 * <ul>
 * <li>The method should be used in a remote proxy or its super classes;</li>
 * <li>The method should provide the public modifier, and the static modifier is
 * also allowed;</li>
 * <li>All methods marked with this annotation could be inherited from its super
 * classes, and overrides of these methods are allowed. If a method marked with
 * this annotation in its super class, but remove this annotation in its
 * inherited class. This method in its inherited class would not be recognized
 * as a web method;</li>
 * <li>Overload methods which both/all marked with this annotation is not
 * allowed.</li>
 * </ul>
 * 
 * @author Kai Feng
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebMethod {
	// Does nothing.
}
