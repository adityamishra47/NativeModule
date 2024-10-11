import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  View,
  NativeModules
} from 'react-native';

function App(): React.JSX.Element {

  const { LoginModule } = NativeModules;

  return (
    <SafeAreaView style={styles.root}>
      <View>
        <Text
          onPress={() => LoginModule.openLoginPage()}
          style={styles.txtBtn}>Open Login Page</Text>
        <Text
          onPress={() => LoginModule.openSignupPage()}
          style={styles.txtBtn}>Open Signup Page</Text>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
    backgroundColor: "pink",
    justifyContent: "center",
    alignItems: "center"
  },
  txtBtn: {
    padding: 14,
    margin: 14,
    borderWidth: 1,
    backgroundColor: "dodgerblue",
    color: "white",
    fontSize: 16
  }
});

export default App;
