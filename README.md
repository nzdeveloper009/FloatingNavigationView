# FloatingNavigationView
A simple & curved & material bottom navigation for Android written in Kotlin


> Step 1. Add the JitPack repository to your build file
> 
```gradle
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

> Step 2. Add the dependency

```gradle
	dependencies {
	        implementation 'com.github.nzdeveloper009:FloatingNavigationView:1.0.0'
	}
```

# Usage
Add Floating Bottom Navigation in you layout xml file.

```Usage
	<com.nokhaiz.floatingnavigaionview.FloatingBottomNavigation
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```
Add menu items in code.

```Add Menu Items
	val bottomNavigation = findView(R.id.bottomNavigation)
	bottomNavigation.add(FloatingBottomNavigation.Model(1, R.drawable.ic_home))
	bottomNavigation.add(FloatingBottomNavigation.Model(2, R.drawable.ic_explore))
	bottomNavigation.add(FloatingBottomNavigation.Model(3, R.drawable.ic_message))
```
Add vectorDrawables.useSupportLibrary = true to your build.gradle inside [defaultConfig{ ... }](https://github.com/nzdeveloper009/FloatingNavigationView) to use vector drawable icons.
## Customization

```xml
    <com.nokhaiz.floatingnavigaionview.FloatingBottomNavigation
            android:id="@+id/bottomNavigation"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            app:mbn_circleColor="#ffffff"
            app:mbn_backgroundBottomColor="#ffffff"
            app:mbn_countBackgroundColor="#ff6f00"
            app:mbn_countTextColor="#ffffff"
            app:mbn_countTypeface="fonts/source_sans_pro_regular.ttf"
            app:mbn_defaultIconColor="#90a4ae"
            app:mbn_rippleColor="#2f424242"
            app:mbn_selectedIconColor="#3c415e"
            app:mbn_shadowColor="#1f212121"
            app:mbn_hasAnimation="true" />
```

- You can change this properties in **Kotlin/Java** Realtime. 

## Listeners

Use `setOnShowListener()` function to access when a cell has been shown.

```kotlin
    bottomNavigation.setOnShowListener {
        // YOUR CODES
    }
```

Use `setOnClickMenuListener()` function to access when a cell has been clicked.

```kotlin     
    bottomNavigation.setOnClickMenuListener {
        // YOUR CODES
    }
```

If you are Java Developer, use this examples :

```java
    floatingBottomNavigation.setOnClickMenuListener(new Function1<FloatingBottomNavigation.Model, Unit>() {
         @Override
         public Unit invoke(FloatingBottomNavigation.Model model) {
             // YOUR CODES
             return null;
        }
    });

    floatingBottomNavigation.setOnShowListener(new Function1<FloatingBottomNavigation.Model, Unit>() {
         @Override
         public Unit invoke(FloatingBottomNavigation.Model model) {
            // YOUR CODES
            return null;
         }
     });
```

If you are Kotlin Developer, use this examples :

```Kotlin
    floatingBottomNavigation.setOnClickMenuListener {
       // YOUR CODES
    }

    floatingBottomNavigation.setOnShowListener { 
       // YOUR CODES
    }
```
## Counter Badge

Set counter badge on a specific cell by `setCount(Int,String)`.

```kotlin
floatingBottomNavigation.setCount(CELL_ID, YOUR_STRING)
```

Clear counter badge on a specific cell by `clearCount(Int)`.

```kotlin
floatingBottomNavigation.clearCount(CELL_ID)
```

Clear all counter badges on a specific cell by `clearCount(Int)`.

```kotlin
floatingBottomNavigation.clearAllCounts(TAB_ID)
```

## Set Default CELL

Use this function :

```kotlin
floatingBottomNavigation.show(CELL_ID)
```

bottomNavigation.clearAllCounts(TAB_ID)

> To Set Default CELL Use this function :
```
floatingBottomNavigation.show(CELL_ID)
```
