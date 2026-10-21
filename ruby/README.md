# Birthstones API - Ruby Gem

Birthstones is a comprehensive lookup API for birthstone information. It returns detailed data about gemstones associated with each birth month, including the primary stone, alternate stones, colors, meanings, and zodiac associations.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_birthstones'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_birthstones
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_birthstones'

# Initialize the client
client = APIVerve::Birthstones::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ month: "5" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ month: "5" })
  puts response["data"]
rescue APIVerve::Birthstones::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Birthstones::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Birthstones::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 1,
    "birthstones": [
      {
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
    ]
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/birthstones?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/birthstones?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/birthstones?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
