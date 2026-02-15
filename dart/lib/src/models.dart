/// Response models for the Birthstones API.

/// API Response wrapper.
class BirthstonesResponse {
  final String status;
  final dynamic error;
  final BirthstonesData? data;

  BirthstonesResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory BirthstonesResponse.fromJson(Map<String, dynamic> json) => BirthstonesResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? BirthstonesData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Birthstones API.

class BirthstonesData {
  int? month;
  String? monthName;
  String? primaryStone;
  List<String>? alternateStones;
  String? color;
  String? meaning;
  List<String>? zodiacSigns;
  double? hardness;
  String? mineralFamily;
  int? anniversaryYear;

  BirthstonesData({
    this.month,
    this.monthName,
    this.primaryStone,
    this.alternateStones,
    this.color,
    this.meaning,
    this.zodiacSigns,
    this.hardness,
    this.mineralFamily,
    this.anniversaryYear,
  });

  factory BirthstonesData.fromJson(Map<String, dynamic> json) => BirthstonesData(
      month: json['month'],
      monthName: json['monthName'],
      primaryStone: json['primaryStone'],
      alternateStones: (json['alternateStones'] as List?)?.cast<String>(),
      color: json['color'],
      meaning: json['meaning'],
      zodiacSigns: (json['zodiacSigns'] as List?)?.cast<String>(),
      hardness: json['hardness'],
      mineralFamily: json['mineralFamily'],
      anniversaryYear: json['anniversaryYear'],
    );
}

class BirthstonesRequest {
  String month;

  BirthstonesRequest({
    required this.month,
  });

  Map<String, dynamic> toJson() => {
      'month': month,
    };
}
