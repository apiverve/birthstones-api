/// Response models for the Birthstones API.

/// API Response wrapper.
class BirthstonesResponse {
  final String status;
  final dynamic error;
  final BirthstonesData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  BirthstonesResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory BirthstonesResponse.fromJson(Map<String, dynamic> json) => BirthstonesResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? BirthstonesData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Birthstones API.

class BirthstonesData {
  num? count;
  List<BirthstonesDataBirthstonesItem>? birthstones;

  BirthstonesData({
    this.count,
    this.birthstones,
  });

  factory BirthstonesData.fromJson(Map<String, dynamic> json) => BirthstonesData(
      count: json['count'],
      birthstones: (json['birthstones'] as List?)?.map((e) => BirthstonesDataBirthstonesItem.fromJson(e)).toList(),
    );
}

class BirthstonesDataBirthstonesItem {
  num? month;
  String? monthName;
  String? primaryStone;
  List<String>? alternateStones;
  String? color;
  String? meaning;
  List<String>? zodiacSigns;
  num? hardness;
  String? mineralFamily;
  num? anniversaryYear;

  BirthstonesDataBirthstonesItem({
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

  factory BirthstonesDataBirthstonesItem.fromJson(Map<String, dynamic> json) => BirthstonesDataBirthstonesItem(
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
