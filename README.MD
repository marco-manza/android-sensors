# Android Sensors

## Serialized JSON

```
{
  "gps": {
    "latitude": 42.360082,
    "longitude": -71.05888,
    "accuracy": 12.12
  },
  "accelerometer": {
    "x": 34.12              // Acceleration force along the x axis (including gravity), m/s2
    "y": 12.02,             // Acceleration force along the y axis (including gravity), m/s2
    "z": 66.99              // Acceleration force along the z axis (including gravity), m/s2
  },
  "gyroscope": {
    "roll": 12.12,          // Rate of rotation around the x axis, rad/s
    "pitch": 33.55,         // Rate of rotation around the y axis, rad/s
    "yaw": 32.99            // Rate of rotation around the z axis, rad/s
  }
}
