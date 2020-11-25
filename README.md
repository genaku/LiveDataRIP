# LiveDataRIP

[![](https://jitpack.io/v/genaku/LiveDataRIP.svg)](https://jitpack.io/#genaku/LiveDataRIP)

Replacement of LiveData and SingleLiveEvent with Kotlin coroutine flow.

## Dependency


Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.genaku:LiveDataRIP:<latest version>'
	}


## Usage
See ["R.I.P. LiveData. Viva Flow!"](https://medium.com/@fenix0gk/livedata-r-i-p-viva-flow-c13461fd2c6b) article.

## License
```
 Copyright 2020, Gena Kuchergin

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
