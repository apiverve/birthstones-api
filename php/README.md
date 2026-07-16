# Birthstones API - PHP Package

Birthstones is a comprehensive lookup API for birthstone information. It returns detailed data about gemstones associated with each birth month, including the primary stone, alternate stones, colors, meanings, and zodiac associations.

## Installation

Install via Composer:

```bash
composer require apiverve/birthstones
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Birthstones\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['month' => '5']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Birthstones\Client;
use APIVerve\Birthstones\Exceptions\APIException;
use APIVerve\Birthstones\Exceptions\ValidationException;

try {
    $response = $client->execute(['month' => '5']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/birthstones?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/birthstones?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/birthstones?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
