/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.bumblebench.methodhandle;


public class Helper implements IHelper {
	int i;

	public Helper(int a1, int a2) {
		this.i = a1 + a2;
	}

	public static int staticFoo(int a1, int a2) {
		return a1 + a2;
	}

	public int virtualFoo(int a1, int a2) {
		return a1 + a2;
	}

	public int interfaceFoo(int a1, int a2) {
		return a1 + a2;
	}
}

