# PrintArray
Android Library for Printing arrays in AlertDialog interface with checkbox.

How to:

To get a Git project into your build:
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  

Step 2. Add the dependency

	dependencies {
		implementation 'com.github.Tobibur:PrintArray:v1.0.0'
	}

Usage:

Call this function below Onclick of a button:

```Java
PrintArray.diafunction(Button symp, String[] listItems, Context context)
```

Sreenshots:

<img src="images/demo1.png" width="300"> <img src="images/demo2.png" width="300">


[![](https://jitpack.io/v/Tobibur/PrintArray.svg)](https://jitpack.io/#Tobibur/PrintArray)
