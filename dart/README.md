# Birthstones API - Dart/Flutter Client

Birthstones is a comprehensive lookup API for birthstone information. It returns detailed data about gemstones associated with each birth month, including the primary stone, alternate stones, colors, meanings, and zodiac associations.

[![pub package](https://img.shields.io/pub/v/apiverve_birthstones.svg)](https://pub.dev/packages/apiverve_birthstones)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Birthstones API](https://apiverve.com/marketplace/birthstones?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_birthstones: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_birthstones/apiverve_birthstones.dart';

void main() async {
  final client = BirthstonesClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'month': '5'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "month": 5,
    "monthName": "May",
    "primaryStone": "Emerald",
    "alternateStones": [
      "Chrysoprase",
      "Agate"
    ],
    "color": "Green",
    "meaning": "Rebirth, love, fertility",
    "zodiacSigns": [
      "Taurus",
      "Gemini"
    ],
    "hardness": 7.5,
    "mineralFamily": "Beryl",
    "anniversaryYear": 55
  }
}
```

## API Reference

- **API Home:** [Birthstones API](https://apiverve.com/marketplace/birthstones?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/birthstones](https://docs.apiverve.com/ref/birthstones?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
